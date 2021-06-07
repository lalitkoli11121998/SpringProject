package com.luv2cod.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
	    //  load the spring configuration or crate the spring container
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-application-Context.xml");
			ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("beanLifeCycle-application-context.xml");
			
//			reterive the bean from spring container
//			at this time spring make a new object with empty contructor
			Coach theCoach = context.getBean("myCoach", Coach.class);
			Coach theCoach1 = context.getBean("myCoach", Coach.class);
			
			Coach cyclecoach = context1.getBean("myCoach", Coach.class);
			System.out.println("cycle context" + cyclecoach.getDailyworkout());

			boolean result = (theCoach == theCoach1);
			
			System.out.println("\nPointing to the same object" + result);
			System.out.println("\nMemory loation for thecaoch" + theCoach);
			System.out.println("\nMemory loation for thecaoch1" + theCoach1);
            context.close();
            context1.close();
//			Coach bcoach = context.getBean("myCoach1", Coach.class);
			
	}

}
