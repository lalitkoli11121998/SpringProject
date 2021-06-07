package com.luv2cod.springdemo;

public class BaseBallCoch implements Coach{

//	make a private field for the dependency 
	private FortuneService fortuneService;
	
//	define a constructor for a dependency injection
	public BaseBallCoch(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	public BaseBallCoch() {
	
	}
	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "do practice batting for 30 minutes";
	}

	@Override
	public String getDailyfortune() {
      //   use forunservice to get a fortune
		return this.fortuneService.getfortune();
	}

	
	
}
