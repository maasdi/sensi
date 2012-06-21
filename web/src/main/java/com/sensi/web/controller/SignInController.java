package com.sensi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jun 19, 2012
 */

@Controller
public class SignInController {
	
	static final Logger logger = LoggerFactory.getLogger(SignInController.class);

	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String loginForm(){
		logger.info("show login form");
		return "signin";
	}
	
}
