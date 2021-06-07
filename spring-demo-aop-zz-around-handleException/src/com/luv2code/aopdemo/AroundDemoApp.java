package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MemberShipDao;
import com.luv2code.aopdemo.service.TrafficeFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
       
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring container
		TrafficeFortuneService trafficeFortuneService = context.getBean("trafficeFortuneService",TrafficeFortuneService.class );
		System.out.println("\n\nMain Program : AroundDemoApp");
		System.out.println("calling fortune service ");
		System.out.println( trafficeFortuneService.getFortune());
		System.out.println("finished");
		//close the context
		context.close();
	}

}
