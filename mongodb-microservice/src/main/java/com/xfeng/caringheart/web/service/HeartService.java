package com.xfeng.caringheart.web.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.xfeng.caringheart.web.dao.HeartRepository;
import com.xfeng.caringheart.web.dto.Heart;
import com.xfeng.caringheart.web.dto.HeartListData;
import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.dto.mapper.HeartMapper;
import com.xfeng.caringheart.web.entity.HeartEntity;

@Service
public class HeartService {

	private static final Logger logger = LoggerFactory.getLogger(HeartService.class);

	@Autowired
	private HeartRepository heartRepository;

	@Autowired
	private HeartMapper mapper;

	@Autowired
	MongoTemplate mongoTemplate;

	public ResultMsg save(HeartListData heart, String userid) {
		logger.info(userid);
		HeartEntity entity = mapper.createEntityFromDto(heart, userid);
		HeartEntity newentity = heartRepository.save(entity);

		return new ResultMsg().code("0").msg(newentity.getId());
	}

	public List<Heart> list(Integer duration, String userid) {
		LocalDate localDate = new LocalDate().plusDays(-duration);
		Date startDate = localDate.toDateTimeAtStartOfDay().toDate();
		logger.debug(startDate.toString());
		Aggregation agg = newAggregation(match(where("date").gte(startDate).and("userid").is(userid)),
				pipeline(
						"{$group: {_id: {_id: '$_id', groupdate: {$substr: ['$date', 0, 10]}, date: '$date', low: '$low', high: '$high', heartbeat: '$heartbeat', weight: '$weight' }}}"),
				pipeline(
						"{$project: {groupdate: '$_id.groupdate', date: '$_id.date', info: {_id: '$_id._id', date: '$_id.date', low: '$_id.low', high: '$_id.high', heartbeat: '$_id.heartbeat', weight: '$_id.weight' }, _id: 0}}"),
				pipeline("{$sort: {date: -1}}"),
				pipeline(
						"{$group: {_id: {date: '$groupdate'}, groupdate: {$max: '$date'}, listdata: {$push: '$info'}}}"),
				pipeline("{$sort: {_id: -1}}"));

		AggregationResults<Heart> results = mongoTemplate.aggregate(agg, "heartEntity", Heart.class);
		List<Heart> mappedResult = results.getMappedResults();
		return mappedResult;
	}

	public ResultMsg delete(HeartListData heart) {

		HeartEntity entity = mapper.createEntityFromDto(heart);
		heartRepository.delete(entity);

		return new ResultMsg().code("0");
	}

	private AggregationOperation pipeline(final String jsonString) {
		return new AggregationOperation() {
			@Override
			public DBObject toDBObject(AggregationOperationContext context) {
				return (DBObject) JSON.parse(jsonString);
			}
		};
	}

}
