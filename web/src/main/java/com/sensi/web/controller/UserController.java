package com.sensi.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensi.service.SecurityService;

/**
*
* @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
* Jun 19, 2012
*/
@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "limit", defaultValue = "0") int limit){
		
		Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("users", securityService.findUsers());
        result.put("total", securityService.countUsers());
        return result;
	}
	
}
