package com.sensi.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensi.domain.Role;
import com.sensi.domain.User;
import com.sensi.domain.UserAlreadyExistException;
import com.sensi.service.RoleService;
import com.sensi.service.UserService;
import com.sensi.web.validator.UserValidator;

@Controller
public class SignUpController {
	
	private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String createAccount(User user, BindingResult errors){
		userValidator.validate(user, errors);
		if(errors.hasErrors()){
			log.info("error signup");
			return "signup";
		}else{
			try {
				Role role = roleService.findRole("ROLE_USER");
				user.getRoles().add(role);
				userService.save(user);
				log.info("success signup");
				return "redirect:/signup";
			} catch (UserAlreadyExistException uae) {
				errors.rejectValue("username", "username.exist");
				return "signup";
			} catch (Exception e) {
				return "signup";
			}
		}
	}

}
