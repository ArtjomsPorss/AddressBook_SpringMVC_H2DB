package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration	// means this class has @Beans annotations
@EnableWebMvc	// means this project will use MVC
@ComponentScan(basePackages="com.example")	// all classes in sub packages of com.example - will 
// be searched for annotations like @Service, @Bean, @Repository..
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean // points to the folder where JSP views located
	public InternalResourceViewResolver getInternalResourceViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Override // resource folder for CSS, fonts and JavaScript files
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		// /src/main/webapp/resources/
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}







/*
 * DONE 01 - create an index JSP and make sure it loads
 * DONE 02 - create a controller that locates home JSP
 * DONE 03 - create a SECOND JSP and locate it from FIRST JSP by button click
 * DONE 04 - submit variables from JSP to controller through POJO
 * DONE 05 - pass variables through redirect
 * DONE 06 - display variables from object on JSP
 * DONE 06.1 - Attach bootstrap
 * DONE 07 - Create a Post Redirect Get pattern
 * DONE 08 - add database to application
 * DONE 09 - connect database to application
 * DONE 10 - create database schema
 * DONE 11 - display info from DB on screen
 * DONE 12 - add and remove data from database
 * DONE 13 - Update current data in the database
 * DONE 14 - create simple CRUD functionality
 * DONE 15 - Create another JSP and use URL path with a button (passing url parameters)
 * 
 * TODO XX - cleanup files that are not used anymore
 * TODO XX - add Testing to my application
 * TODO XX - re-factor to use separate JSP's 
 * TODO XX - find nice styling for JSP's
 * TODO XX - re-factor to split some mixed up DAO classes
 *  
 * TODO XX - create AJAX controller and add javascript to project, 
 * 				attach JS to button click 
 * 				and make AJAX call to AJAX controller  
 * 
 */