package com.xfeng.caringheart.web.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.xfeng.caringheart.web.entity.HeartEntity;

public interface HeartRepository extends MongoRepository<HeartEntity, String> {

	List<HeartEntity> findByDate(DateTime date);

}
