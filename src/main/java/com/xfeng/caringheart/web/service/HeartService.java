package com.xfeng.caringheart.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfeng.caringheart.web.dao.HeartRepository;
import com.xfeng.caringheart.web.model.Heart;
import com.xfeng.caringheart.web.model.HeartListData;
import com.xfeng.caringheart.web.model.ResultMsg;

@Service
public class HeartService {

	@Autowired
	private HeartRepository repository;

	public ResultMsg save(HeartListData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Heart> list(String duration) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg delete(HeartListData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
