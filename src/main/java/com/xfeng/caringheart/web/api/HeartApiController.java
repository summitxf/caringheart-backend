package com.xfeng.caringheart.web.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xfeng.caringheart.web.dto.Heart;
import com.xfeng.caringheart.web.dto.HeartListData;
import com.xfeng.caringheart.web.dto.ResultMsg;
import com.xfeng.caringheart.web.service.HeartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "heart")
@RestController
@RequestMapping(value = "/heart")
public class HeartApiController {

	private static final Logger logger = LoggerFactory.getLogger(HeartApiController.class);

	@Autowired
	HeartService service;

	@ApiOperation(value = "", notes = "delete heart record", response = ResultMsg.class, tags = { "heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	ResultMsg heartDelete(@ApiParam(value = "heart record data", required = true) @RequestBody HeartListData data) {
		// do some magic!
		return service.delete(data);
	}

	@ApiOperation(value = "", notes = "get heart list", response = Heart.class, responseContainer = "List", tags = {
			"heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Heart.class) })
	@RequestMapping(value = "/{duration}", method = RequestMethod.GET)
	@ResponseBody
	List<Heart> heartDurationGet(
			@ApiParam(value = "how many days", required = true) @PathVariable("duration") Integer duration) {
		// do some magic!
		logger.debug(duration.toString());
		String userid = "580f20829b4f730bf085bd42";
		return service.list(duration, userid);
	}

	@ApiOperation(value = "", notes = "save heart record", response = ResultMsg.class, tags = { "heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	ResultMsg heartPost(@ApiParam(value = "heart record data", required = true) @RequestBody HeartListData data) {
		// do some magic!
		String userid = "580f20829b4f730bf085bd42";
		return service.save(data, userid);
	}

}
