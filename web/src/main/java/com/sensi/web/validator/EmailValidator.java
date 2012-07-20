package com.sensi.web.validator;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 20, 2012
 */

@Resource(name="emailValidator")
public class EmailValidator implements Validator {
	
	private final static Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\.[a-z]+");

	@Override
	public boolean supports(Class<?> type) {
		return String.class.equals(type);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String email = (String) target;
		if(!StringUtils.hasText(email)){
			errors.rejectValue("email", "email.required");
		}else if (!isEmail(email)){
			errors.rejectValue("email", "email.invalid");
		}
	}
	
	private boolean isEmail(String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }

}
