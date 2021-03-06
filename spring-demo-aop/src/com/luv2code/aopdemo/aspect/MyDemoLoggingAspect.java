package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all our related advice for logging
	
	
	//lets start with @Before advice
	//it menas we told spring that run the beforeAccountAdvice method before execution of target method(add acount)
	//add account k execution se pahe beforeAccountAdvice method ko call kro
	//execution(public void addAccout()) --> point cut expression
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDao.addAccout())")
	//add preffix vale sare method se pahle ye method call hona chye but unka return return type void ho or public ho
//	@Before("execution(public void add*())")
	
	//@Before("execution( * add*())")
	//koi bhi return type ho or add se sure ho method usse pahle beforeaccoutnadvice method call hoga
	// add*(..) this simplify 0 to many arguments  
//	@Before("execution( * add*(com.luv2code.aopdemo.Account, ..))") means first parameter should be account class and second could be anything
	//@Before("execution( * add*(..))")
	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))") //means com.luv2code.aopdemo.dao is package m koi bhi class ho or us class ka koi bhi method ho uske 
	//execution se pahle beforeaccountadvice run hota h
	public void beforeAccountAdvice() {
		System.out.println("=====> execution @Befor advice add acount");
	}

}
