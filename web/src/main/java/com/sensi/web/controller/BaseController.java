package com.sensi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.ServletContextAware;

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
	public void setMessage( HttpServletRequest request, String message ){
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
	public void setError( HttpServletRequest request, String message ){
		List<String> errors = ( List<String> ) request.getSession().getAttribute( ERRORS_KEY );
		
		if( errors == null ){
			errors = new ArrayList<String>();
		}
		
		errors.add(message);
		request.getSession().setAttribute(ERRORS_KEY, errors);
	}

}
