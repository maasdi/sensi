package com.sensi.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.context.ServletContextAware;

import com.sensi.domain.User;
import com.sensi.web.util.MailEngine;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 18, 2012
 */
public class BaseController implements ServletContextAware {
	
	public static final String MESSAGES_KEY = "messages";
	public static final String ERRORS_KEY = "errors";
	
	private ServletContext servletContext;
	private MessageSourceAccessor messages;	
	private MailEngine mailEngine;

	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	protected ServletContext getServletContext(){
		return servletContext;
	}
	
	/**
	 * Convenience method to set success messages will display
	 * 
	 * @param request @see {@link HttpServletRequest}
	 * @param message, message that will displayed
	 */
	public void addMessage( HttpServletRequest request, String message ){
		List<String> messages = ( List<String> ) request.getSession().getAttribute( MESSAGES_KEY );
		
		if( messages == null ){
			messages = new ArrayList<String>();
		}
		
		messages.add( message );
		request.getSession().setAttribute( MESSAGES_KEY, messages );
	}
	
	/**
	 * Convenience method to set error messages
	 * 
	 * @param request @see {@link HttpServletRequest}
	 * @param message, the error message that will displayed
	 */
	public void addError( HttpServletRequest request, String message ){
		List<String> errors = ( List<String> ) request.getSession().getAttribute( ERRORS_KEY );
		
		if( errors == null ){
			errors = new ArrayList<String>();
		}
		
		errors.add(message);
		request.getSession().setAttribute(ERRORS_KEY, errors);
	}
	
	/**
	 * Use this method to get message 
	 * from ApplicationResources base on code
	 * 
	 * @param code the message key
	 * @param locale the current locale
	 * @return String message
	 */
	public String getText(String code, Locale locale){
		return messages.getMessage(code, locale);
	}
	
	/**
	 * Use this method to get message with one argument
	 * from ApplicationResources base on code
	 * 
	 * @param code the message key
	 * @param args string argument
	 * @param locale current locale
	 * @return String message
	 */
	public String getText(String code, String args, Locale locale){
		return messages.getMessage(code, new Object[]{args}, locale);
	}
	
	/**
	 * Use this method to get message with more than one arguments
	 * from ApplicationResources
	 * 
	 * @param code the message key
	 * @param args Array of {@link Object} as arguments
	 * @param locale current locale
	 * @return String message
	 */
	public String getText(String code, Object[] args, Locale locale){
		return messages.getMessage(code, args, locale);
	}

	@Autowired
	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}
	
	protected void sendUserMessage(User user){
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		String template = "Your account has been created, here your account detail.\n" +
				"Username : %s\n" +
				"Password : %s\n" +
				"\n\n Regards \n\n Sensi ";
		mailMessage.setFrom("maas.dianto@gmail.com");
		mailMessage.setText(user.getEmail());
		mailMessage.setSubject("Sensi Account Created successfull");
		mailMessage.setText(String.format(template, user.getUsername(), user.getConfirmPassword()));
		
		mailEngine.sendMessage(mailMessage);
	}
}
