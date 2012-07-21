package com.sensi.web.controller.user;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensi.domain.User;
import com.sensi.service.UserService;
import com.sensi.web.controller.BaseController;
import com.sensi.web.validator.UserValidator;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 21, 2012
 */

@Controller
public class UserProfileController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/user/profile", method=RequestMethod.GET)
	public String form(Model model, HttpServletRequest request){
		// get current user
		User user = userService.findUsersByUsername(request.getRemoteUser());
		model.addAttribute("user", user);
		return "user/profile";
	}
	
	@RequestMapping(value="/user/profile", method=RequestMethod.POST)
	public String submit(User user, BindingResult errors, HttpServletRequest request){
		Locale locale = request.getLocale();
		
		User currentUser = userService.findUsersByUsername(request.getRemoteUser());
		// apply changes
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setGender(user.getGender());
		currentUser.setEmail(user.getEmail());
		// don't validate confirm password
		currentUser.setConfirmPassword("false");
		
		userValidator.validate(currentUser, errors);
		if(errors.hasErrors()){
			return "user/profile";
		}
		
		try {
			userService.update(currentUser);
			addMessage(request, getText("profile.save.success", locale));
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			addError(request, getText("profile.save.failed", locale));
		}
		
		return "redirect:/user/profile";
	}

}
