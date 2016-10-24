package com.xfeng.caringheart.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xfeng.caringheart.web.model.Heart;
import com.xfeng.caringheart.web.model.HeartListData;
import com.xfeng.caringheart.web.model.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "heart")
@Controller
public class HeartApiController {

	@ApiOperation(value = "", notes = "delete heart record", response = ResultMsg.class, tags = { "heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/heart", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResultMsg> heartDelete(@ApiParam(value = "heart record data") @RequestBody HeartListData body){
		// do some magic!
		return new ResponseEntity<ResultMsg>(HttpStatus.OK);
	}
	@ApiOperation(value = "", notes = "get heart list", response = Heart.class, tags = { "heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Heart.class) })
	@RequestMapping(value = "/heart/{duration}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Heart>> heartDurationGet(
			@ApiParam(value = "day, week, month, default is day") @PathVariable("duration") String duration){
		// do some magic!
		return new ResponseEntity<List<Heart>>(HttpStatus.OK);
	}

	@ApiOperation(value = "", notes = "save heart record", response = ResultMsg.class, tags = { "heart", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResultMsg.class) })
	@RequestMapping(value = "/heart", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<ResultMsg> heartPost(@ApiParam(value = "heart record data") @RequestBody HeartListData body){
		// do some magic!
		return new ResponseEntity<ResultMsg>(HttpStatus.OK);
	}
	

}
