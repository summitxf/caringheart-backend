package com.xfeng.caringheart.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfeng.caringheart.web.dao.WaterRepository;
import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.dto.Water;
import com.xfeng.caringheart.web.dto.WaterListData;
import com.xfeng.caringheart.web.dto.mapper.WaterMapper;

@Service
public class WaterService {

	@Autowired
	private WaterRepository repository;

	@Autowired
	private WaterMapper mapper;

	public ResultMsg save(WaterListData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Water> list(String duration) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg delete(WaterListData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
