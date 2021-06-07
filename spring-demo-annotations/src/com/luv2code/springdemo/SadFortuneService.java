package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getfortune() {
		return "today is a sad day";
	}

}
