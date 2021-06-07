package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

//this class act as targetobject means AOP class
@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	public String getServiceCode() {
		System.out.println(getClass() + "doing  work getServiceCode ");

		return serviceCode;
	}

	public String getName() {
		System.out.println(getClass() + "doing  work getName");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "doing  work setName");

		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "doing  work setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccout(Account theaccount, boolean vipflag) {
		System.out.println(getClass() + "doing my work adding an account");
	}

	public boolean dowork() {
		System.out.println( "do your work");
		return true;
	}
}
