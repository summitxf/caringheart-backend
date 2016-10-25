package com.xfeng.caringheart.web.service;

import java.util.List;

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
	private HeartRepository repository;

	@Autowired
	private HeartMapper mapper;

	public ResultMsg save(HeartListData data) {
		
		HeartEntity entity = mapper.createEntityFromDto(data);
		HeartEntity newData = repository.save(entity);
		logger.info(newData.toString());
		
		return new ResultMsg().code("0");
	}

	public List<Heart> list(String duration) {
		// repository.
		return null;
	}

	public ResultMsg delete(HeartListData data) {
		
		HeartEntity entity = mapper.createEntityFromDto(data);
		repository.delete(entity);
		
		return new ResultMsg().code("0");
	}

}
