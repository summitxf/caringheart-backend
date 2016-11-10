package com.xfeng.caringheart.web.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.xfeng.caringheart.web.entity.WaterEntity;

public interface WaterRepository extends MongoRepository<WaterEntity, String> {

	List<WaterEntity> findByDate(DateTime date);

}
