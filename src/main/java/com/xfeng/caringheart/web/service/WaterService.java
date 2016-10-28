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
import com.xfeng.caringheart.web.dao.WaterRepository;
import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.dto.Water;
import com.xfeng.caringheart.web.dto.WaterListData;
import com.xfeng.caringheart.web.dto.mapper.WaterMapper;
import com.xfeng.caringheart.web.entity.WaterEntity;

@Service
public class WaterService {

	private static final Logger logger = LoggerFactory.getLogger(HeartService.class);

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private WaterMapper mapper;

	@Autowired
	MongoTemplate mongoTemplate;

	public ResultMsg save(WaterListData water, String userid) {
		logger.info(userid);
		WaterEntity entity = mapper.createEntityFromDto(water, userid);
		WaterEntity newentity = waterRepository.save(entity);

		return new ResultMsg().code("0").msg(newentity.getId());
	}

	public List<Water> list(Integer duration, String userid) {
		LocalDate localDate = new LocalDate().plusDays(-duration);
		Date startDate = localDate.toDateTimeAtStartOfDay().toDate();
		logger.debug(startDate.toString());
		Aggregation agg = newAggregation(match(where("date").gte(startDate).and("userid").is(userid)),
				pipeline(
						"{$project: {date: 1, type: 1, amount: 1, inamount: {$cond: {if: {$eq: ['$type', 'in']}, then: '$amount', else: 0}}, outamount: {$cond: {if: {$eq: ['$type', 'out']}, then: '$amount', else: 0}}, _id: 1}}"),
				pipeline(
						"{$group: {_id: {_id: '$_id', groupdate: {$substr: ['$date', 0, 10]}, date: '$date', type: '$type', amount: '$amount', }, groupinamount: {$sum: '$inamount'}, groupoutamount: {$sum: '$outamount'}}}"),
				pipeline(
						"{$project: {groupdate: '$_id.groupdate', date: '$_id.date', groupinamount: 1, groupoutamount: 1, info: {_id: '$_id._id', date: '$_id.date', type: '$_id.type', amount: '$_id.amount', }, _id: 0}}"),
				pipeline(
						"{$group: {_id: {date: '$groupdate'}, groupdate: {$max: '$date'}, groupinamount: {$sum: '$groupinamount'}, groupoutamount: {$sum: '$groupoutamount'}, listdata: {$push: '$info'}}}"),
				pipeline("{$sort: {_id: -1}}"));

		AggregationResults<Water> results = mongoTemplate.aggregate(agg, "waterEntity", Water.class);
		List<Water> mappedResult = results.getMappedResults();
		return mappedResult;
	}

	public ResultMsg delete(WaterListData water) {

		WaterEntity entity = mapper.createEntityFromDto(water);
		waterRepository.delete(entity);

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
