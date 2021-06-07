package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

//this class act as targetobject means AOP class
@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	//add a new method :findaccount()
	
	public List<Account> findAccount(){
		List<Account> myaccounts = new ArrayList<>();
		//create sample acount
		Account account =new Account("john", "silver");
		Account account1 =new Account("Madhu", "platinum");
		Account account2 =new Account("luca", "gold");
	    myaccounts.add(account);
	    myaccounts.add(account1);
	    myaccounts.add(account2);
	    
	    return myaccounts;
	}
	
	
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
