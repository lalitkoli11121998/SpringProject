package com.luv2cod.springdemo;

public class TrackCoach implements Coach {

	
	
//	make a private field for the dependency 
	private FortuneService fortuneService;
	
//	define a constructor for a dependency injection
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	public TrackCoach() {
		
	}
	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		
		return "Trackcoach give three punishment";
	}

	@Override
	public String getDailyfortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
//   add a init method
	 public String myinitmethod() {
		 return "just do it:" + this.fortuneService.getfortune();
	 }
//	 add destroy method
	 public void mydestroymethod() {
		 System.out.println("trackCoach : inside method domycleanstuff");
	 }
} 











