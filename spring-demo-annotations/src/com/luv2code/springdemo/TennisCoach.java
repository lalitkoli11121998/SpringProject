package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//we can use as bean id or don't give any id because if we add only component annotation here then spring automatically 
//known that it is a bean in which id is the classname with first letter should be small

//@Component("thatSillyCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	//this called field injection
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
//	@Autowired
//    TennisCoach(FortuneService fortuneService){
//	 this.fortuneService = fortuneService;	
//	}
    
	TennisCoach(){	
		System.out.println("spring called TENNIS CONSTRUCTOR");
	}
	
	//create a setter method for injection the fortuneservice
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("spring called setter method of teniscoach");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public void randomMethod(FortuneService fortuneService) {
//		System.out.println("spring called random method of teniscoach");
//		this.fortuneService = fortuneService;
//	}
//	@Autowired(required = false)
//	public void randomMethod2(FortuneService fortuneService) {
//		System.out.println("spring called random method2 of teniscoach");
//		this.fortuneService = fortuneService;
//	}
	@Override
	public String dailyworkout() {
		return "practice your backend volley for ";
	}

	@Override
	public String getdailyforune() {
		return fortuneService.getfortune();
	}
	
	@PostConstruct
	public void initmethod() {
		System.out.println("init method is called");
	}

	@PreDestroy
	public void destroyit() {
		System.out.println("destroy method is called");
	}
}
