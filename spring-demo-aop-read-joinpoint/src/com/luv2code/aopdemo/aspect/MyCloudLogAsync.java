package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsync {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNogettersetter()") //spring check that @pointcut in the class
	public void logToCloudAsync() {
		System.out.println("=====> execution @Befor log to cloud ");
	}
}
