package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
      //READ SPRING CONFIG FILE
//		read java config file
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

	  //get the bean from spring container
//	  Coach coach = context.getBean("thatSillyCoach", Coach.class);
	  Coach coach = context.getBean("tennisCoach", Coach.class);
	  SwimCoach swimcoach = context.getBean("swimCoach", SwimCoach.class);

	  //CALL THE METHOD ON THE BEAN
	  System.out.println(coach.dailyworkout());
	  System.out.println(swimcoach.dailyworkout());
	  System.out.println(swimcoach.getEmail());


	  //call method to get daily fortune
	  System.out.println(coach.getdailyforune());
	  System.out.println(swimcoach.getdailyforune());
	  System.out.println(swimcoach.getTeam());

	  //close the context
	  context.close();
	}

}
