package com.xfeng.caringheart.web.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xfeng.caringheart.web.model.Water;

public interface HeartRepository extends MongoRepository<Water, String> {
	
//	Water findByTitle(String title);
//
//	List<Water> findByDate(String date);

}
