package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficeFortuneService {

	public String getFortune() {
		//SIMULATE A DELEY
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		//RETURN A FORUNE
		return "Except traffic in the early morning";
	}
}
