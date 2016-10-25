package com.xfeng.caringheart.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfeng.caringheart.web.dao.UserRepository;
import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.dto.User;
import com.xfeng.caringheart.web.dto.UserPwd;
import com.xfeng.caringheart.web.dto.mapper.UserMapper;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	public ResultMsg save(UserPwd data) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg findUser(UserPwd data) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg update(User data) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg delete(User data) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMsg changepwd(UserPwd data) {
		// TODO Auto-generated method stub
		return null;
	}

}
