package com.xfeng.caringheart.web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xfeng.caringheart.web.api.HeartApiController;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class SwaggerUIController {

	private static final Logger logger = LoggerFactory.getLogger(HeartApiController.class);

	@RequestMapping(value = "/")
	public String index() {
		logger.debug("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}