package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all our related advice for logging
	
	
	//lets start with @Before advice
	
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before("forDaoPackage()") // 
	//execution se pahle beforeaccountadvice run hota h
	public void beforeAccountAdvice() {
		System.out.println("=====> execution @Befor advice add acount");
	}
	
	@Before("forDaoPackage()") // 
	//execution se pahle beforeaccountadvice run hota h
	public void beforeAccountAdvice2() {
		System.out.println("=====> execution @Befor advice add acount again");
	}

}
