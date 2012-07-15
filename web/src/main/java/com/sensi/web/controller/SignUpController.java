package com.sensi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensi.domain.User;

@Controller
public class SignUpController {
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("user", new User());
		return "signup";
	}

}
