package com.luv2code.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficeFortuneService;

public class AroundDemoLoggerApp {

	private static Logger mylogger =
			Logger.getLogger(AroundDemoLoggerApp.class.getName());
	
	public static void main(String[] args) {
       
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring container
		TrafficeFortuneService trafficeFortuneService = context.getBean("trafficeFortuneService",TrafficeFortuneService.class );
		mylogger.info("\n\nMain Program : AroundDemoApp");
		mylogger.info("calling fortune service ");
		mylogger.info( trafficeFortuneService.getFortune());
		mylogger.info("finished");
		//close the context
		context.close();
	}

}
