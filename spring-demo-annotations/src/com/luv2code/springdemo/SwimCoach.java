package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	private FortuneService fortuneService;
	
    public SwimCoach(FortuneService fortuneService1) {
    	fortuneService = fortuneService1;
    }
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	
	@Override
	public String dailyworkout() {
		return "swim 100 meter daily";
	}

	@Override
	public String getdailyforune() {
		return fortuneService.getfortune();
	}

}
