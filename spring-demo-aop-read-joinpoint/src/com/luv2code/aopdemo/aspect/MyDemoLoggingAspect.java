package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNogettersetter()") // 
	//to read the parameter which pass in the pointcut methods we use joinpoint
	public void beforeAccountAdvice(JoinPoint thejoinpoint) {
		System.out.println("=====> execution @Befor advice add acount");
		
		//diplay the method signature
		MethodSignature methodsignature = (MethodSignature)thejoinpoint.getSignature();
		System.out.println("method :" + methodsignature);
		
		//display the method arguments
		
		// get args
		Object []args = thejoinpoint.getArgs();
		
		//loop the arg
		for(Object arg : args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				Account theAccount = (Account)arg;
				System.out.println("account name :" + theAccount.getName());
				System.out.println("account level :" + theAccount.getLevel());
			}
		}
	}
	
}
