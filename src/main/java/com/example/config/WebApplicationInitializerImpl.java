package com.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// To configure servletContext
public class WebApplicationInitializerImpl implements WebApplicationInitializer {
	
	@Override	// configuring dispatcherServlet for application to handle URL requests
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext();
				
		servletContext.addListener(new ContextLoaderListener(context));
		
		ServletRegistration.Dynamic dispatcher = 
				servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html"); //to handle all .html URL requests from browser
	}	

	// registering @Configuration classes
	private WebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = 
				new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		
		return context;
	}
}

