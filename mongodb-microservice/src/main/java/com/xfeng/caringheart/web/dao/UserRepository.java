package com.xfeng.caringheart.web.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xfeng.caringheart.web.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {

	UserEntity findById(String id);

	UserEntity findByUsernameAndPassword(String username, String password);

	UserEntity findByUsername(String username);

}
