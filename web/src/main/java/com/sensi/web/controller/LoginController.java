package com.sensi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensi.domain.User;
import com.sensi.service.SecurityService;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 19, 2012
 */

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(){
		logger.info("show login form");
		return "login";
	}
	
	/** login just prototype not yet complete */
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
		User user = securityService.findUsersByUsername(username);
		if(user != null && user.getPassword().equals(password)){
			logger.info("redirect to users page");
			return "redirect:users";
		}else{
			logger.info("filed !! redirect to login page");
			return "redirect:login";
		}
	}
	
	/** handle logout, just prototype not yet complete*/
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		logger.info("user logout");
		return "redirect:login";
	}
}
