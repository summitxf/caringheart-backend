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

import com.xfeng.caringheart.web.model.ResultMsg;
import com.xfeng.caringheart.web.model.Water;
import com.xfeng.caringheart.web.model.WaterListData;
import com.xfeng.caringheart.web.service.WaterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "water")
@RestController
@RequestMapping(value = "/water")
public class WaterApiController {

	private static final Logger logger = LoggerFactory.getLogger(WaterApiController.class);

	@Autowired
	WaterService service;

	@ApiOperation(value = "", notes = "delete water record", response = ResultMsg.class, tags = { "water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	ResultMsg waterDelete(@ApiParam(value = "water record data", required = true) @RequestBody WaterListData data) {
		// do some magic!
		return service.delete(data);
	}

	@ApiOperation(value = "", notes = "get water list", response = Water.class, responseContainer = "List", tags = {
			"water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Water.class) })
	@RequestMapping(value = "/{duration}", method = RequestMethod.GET)
	@ResponseBody
	List<Water> waterDurationGet(
			@ApiParam(value = "day, week, month, default is day", required = true) @PathVariable("duration") String duration) {
		// do some magic!
		logger.debug(duration);
		return service.list(duration);
	}

	@ApiOperation(value = "", notes = "save water record", response = ResultMsg.class, tags = { "water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	ResultMsg waterPost(@ApiParam(value = "water record data", required = true) @RequestBody WaterListData data) {
		// do some magic!
		return service.save(data);
	}

}
