package com.xfeng.caringheart.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xfeng.caringheart.web.dto.Heart;
import com.xfeng.caringheart.web.entity.HeartEntity;

@Mapper
public interface HeartRepository {

	HeartEntity save(HeartEntity entity);

	List<Heart> list(Date startDate, String userid);

	void delete(HeartEntity entity);

}
