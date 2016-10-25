package com.xfeng.caringheart.web.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xfeng.caringheart.web.entity.WaterEntity;

public interface WaterRepository extends MongoRepository<WaterEntity, String> {
	


}
