package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFotuneService implements FortuneService {

	@Override
	public String getfortune() {
		return "fortuen given by random service";
	}

}
