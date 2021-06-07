package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {

	@Override
	public String getfortune() {

		return "the is fortune for restfortuneservice";
	}

}
