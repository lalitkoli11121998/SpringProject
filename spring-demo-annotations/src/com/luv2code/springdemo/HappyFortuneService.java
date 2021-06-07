package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    public String [] fortunes = {"myforune is mybes","you can do it", "you are the best", "you are awsome"};
    Random rand = new Random();
	@Override
	public String getfortune() {
		int index = rand.nextInt(3);
		return this.fortunes[index];
	}

}
