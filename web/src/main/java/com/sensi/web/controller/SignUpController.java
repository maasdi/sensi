package com.sensi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensi.domain.Role;
import com.sensi.domain.User;
import com.sensi.domain.UserExistException;
import com.sensi.service.RoleService;
import com.sensi.service.UserService;
import com.sensi.web.validator.UserValidator;

@Controller
public class SignUpController extends BaseController {
	
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
	public String createAccount(User user, BindingResult errors, HttpServletRequest request){
		userValidator.validate(user, errors);
		if(errors.hasErrors()){
			setError(request, "You have entered invalid data");
			return "signup";
		}else{
			try {
				Role role = roleService.findRole("ROLE_USER");
				user.getRoles().add(role);
				userService.createAccount(user);
				setMessage(request, "Your account successfull created");
				return "redirect:/signup";
			} catch (UserExistException ue) {
				errors.rejectValue("username", "username.exist");
				setError(request, "You have entered invalid data");
				return "signup";
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				setError(request, "Sorry, something wrong. Please come next time");
				return "signup";
			}
		}
	}
	
	@RequestMapping(value="/signup/isavailable", method=RequestMethod.GET)
	public @ResponseBody boolean isUserAvailable(@RequestParam("username") String username){
		return userService.findUsersByUsername(username) != null;
	}

}
