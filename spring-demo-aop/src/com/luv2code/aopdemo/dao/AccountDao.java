package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

//this class act as targetobject means AOP class
@Component
public class AccountDao {
	
	public void addAccout(Account theaccount, boolean vipflag) {
		System.out.println(getClass() + "doing my work adding an account");
	}

	public boolean dowork() {
		System.out.println( "do your work");
		return true;
	}
}
