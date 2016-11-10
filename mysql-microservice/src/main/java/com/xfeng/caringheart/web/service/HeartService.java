package com.xfeng.caringheart.web.service;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public ResultMsg save(HeartListData heart, String userid) {
		logger.info(userid);
		HeartEntity entity = mapper.createEntityFromDto(heart, userid);
		HeartEntity newentity = heartRepository.save(entity);

		return new ResultMsg().code("0").msg(newentity.getId());
	}

	public List<Heart> list(Integer duration, String userid) {
		LocalDate localDate = new LocalDate().plusDays(-duration);
		Date startDate = localDate.toDateTimeAtStartOfDay().toDate();
		List<Heart> list = heartRepository.list(startDate, userid);
		return list;
	}

	public ResultMsg delete(HeartListData heart) {

		HeartEntity entity = mapper.createEntityFromDto(heart);
		heartRepository.delete(entity);

		return new ResultMsg().code("0");
	}

}
