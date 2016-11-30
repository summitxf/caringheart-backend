package com.xfeng.caringheart.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.dto.TokenRsp;
import com.xfeng.caringheart.web.dto.User;
import com.xfeng.caringheart.web.dto.UserPwd;
import com.xfeng.caringheart.web.security.JwtUtil;
import com.xfeng.caringheart.web.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(value = "user")
@RestController
@RequestMapping(value = "/user")
public class UserApiController {

	private static final Logger logger = LoggerFactory.getLogger(WaterApiController.class);

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	UserService service;

	@ApiOperation(value = "", notes = "user change password", response = ResultMsg.class, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/changepwd", method = RequestMethod.PUT)
	@ResponseBody
	ResultMsg userChangepwdPut(@ApiParam(value = "user pwd data", required = true) @RequestBody UserPwd data) {
		// do some magic!
		logger.debug(data.toString());
		return service.changepwd(data);
	}

	@ApiOperation(value = "", notes = "delete user record", response = ResultMsg.class, authorizations = {
			@Authorization(value = "user_token") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(produces = { "application/json" }, method = RequestMethod.DELETE)
	@ResponseBody
	ResultMsg userDelete(
			@ApiParam(value = "delete user data, at lease user id", required = true) @RequestBody User data) {
		// do some magic!
		return service.delete(data);
	}

	@ApiOperation(value = "", notes = "update user data", response = ResultMsg.class, authorizations = {
			@Authorization(value = "user_token") }, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(produces = { "application/json" }, method = RequestMethod.PUT)
	@ResponseBody
	ResultMsg userPut(@ApiParam(value = "user data", required = true) @RequestBody User data) {
		// do some magic!
		if (service.checkUsernameExist(data)) {
			return service.update(data);
		}
		return new ResultMsg().code("1").msg("This username is not exist");
	}

	@ApiOperation(value = "", notes = "user login system", response = ResultMsg.class, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	@ResponseBody
	TokenRsp userSigninPost(
			@ApiParam(value = "user data, include username & password", required = true) @RequestBody User data) {

		boolean isvalid = service.validUser(data);

		if (isvalid) {
			User user = service.getUserByName(data.getUsername());
			String token = jwtUtil.generateToken(user);

			// Return the token
			return new TokenRsp(token);
		}
		return null;
	}

	@ApiOperation(value = "", notes = "user logout system", response = ResultMsg.class, tags = { "user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/signout", method = RequestMethod.POST)
	@ResponseBody
	ResultMsg userSignoutPost(
			@ApiParam(value = "user data, only username is enough", required = true) @RequestBody User data) {
		// do some magic!
		return new ResultMsg().code("0");
	}

	@ApiOperation(value = "", notes = "user signup system, create user data", response = ResultMsg.class, tags = {
			"user", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	ResultMsg userSignupPost(
			@ApiParam(value = "user data, at least username & password", required = true) @RequestBody User data) {
		// do some magic!
		if (service.checkUsernameExist(data)) {
			return new ResultMsg().code("1").msg("This username cannot be used");
		}
		User user = service.save(data);
		return new ResultMsg().code("0").msg("");
	}

}
