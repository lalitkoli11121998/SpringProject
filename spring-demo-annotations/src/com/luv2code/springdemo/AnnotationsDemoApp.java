package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {
      //READ SPRING CONFIG FILE
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      
	  //get the bean from spring container
//	  Coach coach = context.getBean("thatSillyCoach", Coach.class);
	  Coach coach = context.getBean("tennisCoach", Coach.class);
	  
	  //CALL THE METHOD ON THE BEAN
	  System.out.println(coach.dailyworkout());
	  
	  //call method to get daily fortune
	  System.out.println(coach.getdailyforune());
	  
	  //close the context
	  context.close();
	}

}
