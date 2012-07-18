package com.sensi.web.controller;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 18, 2012
 */
public class BaseController implements ServletContextAware {
	
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	protected ServletContext getServletContext(){
		return servletContext;
	}

}
