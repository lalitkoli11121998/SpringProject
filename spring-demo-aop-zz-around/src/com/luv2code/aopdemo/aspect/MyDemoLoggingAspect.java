package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	
	//add new adivce @AfterReturning advie
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGeTfortune(
			ProceedingJoinPoint theProceedingJoinPoint //this is handle to target method
			) throws Throwable{
		
		//print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("=====> execution @Around advice add acount: " + method);

		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed(); //execute the target method
		
		//ger end time
		
		long end =  System.currentTimeMillis();
		
		long dur = end - begin;
		
		System.out.println("=====> duration: " + dur/1000.0 + " second");
		return result;
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))")
	public void afterAccountAdvice(
			JoinPoint joinpoint 
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("=====> execution @After advice add acount: " + method);

		
	}
	
	@AfterThrowing(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
			throwing ="thexp") //the result contain the return value of the findaccount method
	public void afterThrowinFindAccountAdvice(
			JoinPoint joinpoint , Throwable thexp //this result should be match with line 22 result
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("=====> execution @AfterResult advice add acount: " + method);
		
		
		//print out the result
		System.out.println("\n=========> excepton is : "+ thexp);
		
		//we can also modify the result here and ye result modifiy ho jayega or yhi modify list jayegi jaha ye method call kiya hua h
		
		//covert the acount name to upperase
		////convertaccountanmetouppercase(result);
		//System.out.println("\n=========> after moddify result is : "+ result);
		
	}
	
	@AfterReturning(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
			returning ="result") //the result contain the return value of the findaccount method
	public void afterReturningFindAccountAdvice(
			JoinPoint joinpoint , List<Account>result //this result should be match with line 22 result
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("=====> execution @AfterResult advice add acount: " + method);
		
		
		//print out the result
		System.out.println("\n=========> result is : "+ result);
		
		//we can also modify the result here and ye result modifiy ho jayega or yhi modify list jayegi jaha ye method call kiya hua h
		
		//covert the acount name to upperase
		convertaccountanmetouppercase(result);
		System.out.println("\n=========> after moddify result is : "+ result);
		
	}
	
	
	private void convertaccountanmetouppercase(List<Account> result) {
	     
		for(Account tempaccount : result) {
			String thname = tempaccount.getName().toUpperCase();
			tempaccount.setName(thname);
		}
	}


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
