package com.sensi.web.controller.user;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensi.domain.User;
import com.sensi.service.UserService;
import com.sensi.web.controller.BaseController;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 21, 2012
 */

@Controller
public class UserAccountController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(UserAccountController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/user/account", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("user", new User());
		return "user/account";
	}
	
	@RequestMapping(value="/user/account", method=RequestMethod.POST)
	public String submit(User user, BindingResult errors, HttpServletRequest request, HttpServletResponse response){
		// validation
		if(!StringUtils.hasText(user.getPassword())){
			errors.rejectValue("password", "password.required");
		}
		
		if(!StringUtils.hasText(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "confirmPassword.required");
		} else if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "confirmPassword.invalid");
		}
		
		if(errors.hasErrors()){
			return "user/account";
		}
		// if validation satisfied, process !!
		User currUser = userService.findUsersByUsername(request.getRemoteUser());
		currUser.setPassword(user.getPassword());
		
		if(passwordEncoder != null){
			currUser.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		}
		
		Locale locale = request.getLocale();
		
		try {
			userService.update(currUser);
			addMessage(request, getText("account.save.success", locale));
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			addError(request, getText("account.save.failed", locale));
		}
		
		return "redirect:/user/profile";
	}

}
