package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 //CALL THE METHOD ON THE BEAN
	    Coach coach = context.getBean("tennisCoach", Coach.class);
//	    Coach coach1 = context.getBean("tennisCoach", Coach.class);
		System.out.println(coach.dailyworkout());
//		System.out.println(coach);
//		System.out.println(coach1);

		  //call method to get daily fortune
		System.out.println(coach.getdailyforune());
		context.close();
	}

}
