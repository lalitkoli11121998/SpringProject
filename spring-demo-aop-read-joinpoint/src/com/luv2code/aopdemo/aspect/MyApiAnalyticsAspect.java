package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {

	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNogettersetter()") // spring check that @pointcut in the LuvAopExpression class
	public void performApiAnalytics() {
		System.out.println("=====> execution @Befor perform API analytcs");
	}
}
