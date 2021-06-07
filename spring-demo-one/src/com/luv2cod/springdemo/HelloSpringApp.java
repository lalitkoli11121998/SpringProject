package com.luv2cod.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
    //  load the spring configuration or crate the spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		reterive the bean from spring container
//		at this time spring make a new object with empty contructor
		Coach theCoach = context.getBean("myCoach", Coach.class);
		FortuneService fs = context.getBean("myFortuneService",FortuneService.class );
//		Coach bcoach = context.getBean("myCoach1", Coach.class);
		
//		call the method
		//String s = theCoach.getDailyfortune();
		//System.out.println(s);
		System.out.println(fs.getfortune());
		System.out.println(theCoach.getDailyworkout());
		
		
//		close the context
		context.close();
	}

}
