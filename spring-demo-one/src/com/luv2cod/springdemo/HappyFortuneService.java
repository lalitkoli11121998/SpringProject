package com.luv2cod.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService{
    public String [] fortunes = {"myforune is mybes","you can do it", "you are the best", "you are awsome"};
    Random rand = new Random();
    
    public HappyFortuneService(){
    	System.out.println("constructor is called for happfortune");
    }
	@Override
	public String getfortune() {
		int index = rand.nextInt(3);
		return this.fortunes[index];
		
	}

}
