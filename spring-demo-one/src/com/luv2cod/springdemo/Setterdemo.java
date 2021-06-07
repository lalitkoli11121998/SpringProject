package com.luv2cod.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Setterdemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Coach thecoach = context.getBean("myCricketcoach", Coach.class);
		CricketCoach thecoach = context.getBean("myCricketcoach", CricketCoach.class);
        String s = thecoach.getDailyfortune();
        System.out.println(s);
        System.out.println(thecoach.getDailyworkout());
        System.out.println(thecoach.getEmailaddress());
        System.out.println(thecoach.getTeamname());
        context.close();
	}

}
