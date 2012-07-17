package com.sensi.web.validator;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sensi.domain.User;

/**
*
* @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
* July 15, 2012
*/
@Resource(name="userValidator")
public class UserValidator implements Validator {
	
	private final static Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\.[a-z]+");

	@Override
	public boolean supports(Class<?> type) {
		return User.class.equals(type);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "username", "username.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.required");
		// confirm password validation
		if(!StringUtils.hasText(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "confirmPassword.required");
		}else if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "confirmPassword.invalid");
		}
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required");
		// email validation
		if(!StringUtils.hasText(user.getEmail())){
			errors.rejectValue("email", "email.required");
		}else if (!isEmail(user.getEmail())){
			errors.rejectValue("email", "email.invalid");
		}
	}
	
	private boolean isEmail(String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }

}
