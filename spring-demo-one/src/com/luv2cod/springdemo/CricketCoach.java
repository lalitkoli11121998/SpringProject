package com.luv2cod.springdemo;

public class CricketCoach implements Coach {

//	make a private field for the dependency 
	private FortuneService fortuneService;
	
//	add new field as inject dependency listerals
	private String emailaddress;
	private String teamname;
	
    public String getEmailaddress() {
    	System.out.println("HI I AM IN email SETER");
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	public String getTeamname() {
		return teamname;
	}


	public void setTeamname(String teamname) {
		System.out.println("HI I AM IN teamname SETER");
		this.teamname = teamname;
	}


	//	define a constructor for a dependency injection
	public CricketCoach() {
	System.out.println("cricketcoach inside no arg constructor");
	}
	
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("HI I AM IN CRICKET SETER");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyfortune() {
		return fortuneService.getfortune();
	}

	@Override
	public String getDailyworkout() {
		return "practice fast bowlling for 15 minutes";
		
	}

}
