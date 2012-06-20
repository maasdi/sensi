package com.sensi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 19, 2012
 */

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(){
		logger.info("show login form");
		return "login";
	}
	
}
