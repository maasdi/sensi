package com.sensi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensi.domain.ForgotPassword;
import com.sensi.domain.User;
import com.sensi.service.UserService;
import com.sensi.web.validator.EmailValidator;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 20, 2012
 */

@Controller
public class ForgotPasswordController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(ForgotPasswordController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private EmailValidator emailValidator;
	
	@RequestMapping(value="/forgot_password", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("forgotPassword", new ForgotPassword());
		return "forgotPassword";
	}
	
	@RequestMapping(value="/forgot_password", method=RequestMethod.POST)
	public String sendPassword(ForgotPassword forgotPassword, BindingResult errors, HttpServletRequest request){
		
		emailValidator.validate(forgotPassword.getEmail(), errors);
		if(errors.hasErrors()){
			return "forgotPassword";
		}
		
		User user = userService.findUserByEmail(forgotPassword.getEmail());
		if(user == null){
			errors.rejectValue("email", "forgotPassword.email.unregistered");
			return "forgotPassword";
		}
		
		try {
			String template = "Dear %s, \nHere your account detail :\n" +
					"Username : %s\n" +
					"Password : %s\n" +
					"\n\nRegards \n\nSensi ";
			sendUserMessage(user, String.format(template, user.getUsername(), user.getUsername(), user.getConfirmPassword()), getText("label.forgotPassword.title", request.getLocale()));
			// set success message
			addMessage(request, getText("forgotPassword.email.send", request.getLocale()));
		} catch (MailException mailException) {
			log.error(mailException.getMessage(), mailException);
			addError(request, getText("forgotPassword.email.failed", request.getLocale()));
		}
		
		return "redirect:forgot_password";
	}

}
