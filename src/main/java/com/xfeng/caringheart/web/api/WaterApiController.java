package com.xfeng.caringheart.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xfeng.caringheart.web.model.ResultMsg;
import com.xfeng.caringheart.web.model.Water;
import com.xfeng.caringheart.web.model.WaterListData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "water")
@Controller
public class WaterApiController {

	@ApiOperation(value = "", notes = "delete water record", response = ResultMsg.class, tags = { "water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/water", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResultMsg> waterDelete(@ApiParam(value = "water record data") @RequestBody WaterListData body) {
		// do some magic!
		return new ResponseEntity<ResultMsg>(HttpStatus.OK);
	}

	@ApiOperation(value = "", notes = "get water list", response = Water.class, tags = { "water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Water.class) })
	@RequestMapping(value = "/water/{duration}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Water>> waterDurationGet(
			@ApiParam(value = "day, week, month, default is day") @PathVariable("duration") String duration) {
		// do some magic!
		return new ResponseEntity<List<Water>>(HttpStatus.OK);
	}

	@ApiOperation(value = "", notes = "save water record", response = ResultMsg.class, tags = { "water", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/water", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<ResultMsg> waterPost(@ApiParam(value = "water record data") @RequestBody WaterListData body) {
		// do some magic!
		return new ResponseEntity<ResultMsg>(HttpStatus.OK);
	}

}
