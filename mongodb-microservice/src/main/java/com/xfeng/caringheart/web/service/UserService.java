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
import com.xfeng.caringheart.web.entity.UserEntity;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	public User save(User data) {
		UserEntity entity = mapper.createEntityFromDto(data);
		UserEntity newentity = repository.save(entity);
		return mapper.createDtoFromEntity(newentity);
	}

	public boolean checkUsernameExist(User data) {
		UserEntity entity = repository.findByUsername(data.getUsername());

		if (null != entity && entity.getUsername().equals(data.getUsername())) {
			return true;
		}
		return false;
	}

	public ResultMsg validUser(User data) {
		UserEntity entity = repository.findByUsernameAndPassword(data.getUsername(), data.getPassword());

		if (null != entity && entity.getUsername().equals(data.getUsername())) {
			return new ResultMsg().code("0");
		}
		return new ResultMsg().code("1").msg("User not found");
	}

	public ResultMsg update(User data) {
		UserEntity entity = mapper.createEntityFromDto(data);
		UserEntity newentity = repository.save(entity);
		return new ResultMsg().code("0").msg(newentity.getId());
	}

	public ResultMsg delete(User data) {
		UserEntity entity = repository.findById(data.getId());
		repository.delete(entity);
		return new ResultMsg().code("0");
	}

	public ResultMsg changepwd(UserPwd data) {
		UserEntity entity = repository.findByUsernameAndPassword(data.getUsername(), data.getPassword());
		if (null != entity) {
			entity.setPassword(data.getNewpassword());
			UserEntity newentity = repository.save(entity);
			return new ResultMsg().code("0").msg(newentity.getId());
		}
		return new ResultMsg().code("1").msg("User not exist or password invalid");
	}

}
