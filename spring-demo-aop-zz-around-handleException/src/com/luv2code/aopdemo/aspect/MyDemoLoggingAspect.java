package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
import com.luv2code.aopdemo.AroundDemoLoggerApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger mylogger =
			Logger.getLogger(getClass().getName());
	//add new adivce @AfterReturning advie
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGeTfortune(
			ProceedingJoinPoint theProceedingJoinPoint //this is handle to target method
			) throws Throwable{
		
		//print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		mylogger.info("=====> execution @Around advice add acount: " + method);

		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		}catch(Exception ex) {
			mylogger.info(ex.getMessage());
			
			result  = "result has been changed due to exception rises";
			
//			we can rethrow the exception without changing it
//			throw ex;
		}
		 //execute the target method
		
		return result;
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))")
	public void afterAccountAdvice(
			JoinPoint joinpoint 
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		mylogger.info("=====> execution @After advice add acount: " + method);

		
	}
	
	@AfterThrowing(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
			throwing ="thexp") //the result contain the return value of the findaccount method
	public void afterThrowinFindAccountAdvice(
			JoinPoint joinpoint , Throwable thexp //this result should be match with line 22 result
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		mylogger.info("=====> execution @AfterResult advice add acount: " + method);
		
		
		//print out the result
		mylogger.info("\n=========> excepton is : "+ thexp);
		
		//we can also modify the result here and ye result modifiy ho jayega or yhi modify list jayegi jaha ye method call kiya hua h
		
		//covert the acount name to upperase
		////convertaccountanmetouppercase(result);
		//mylogger.info("\n=========> after moddify result is : "+ result);
		
	}
	
	@AfterReturning(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccount(..))",
			returning ="result") //the result contain the return value of the findaccount method
	public void afterReturningFindAccountAdvice(
			JoinPoint joinpoint , List<Account>result //this result should be match with line 22 result
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		mylogger.info("=====> execution @AfterResult advice add acount: " + method);
		
		
		//print out the result
		mylogger.info("\n=========> result is : "+ result);
		
		//we can also modify the result here and ye result modifiy ho jayega or yhi modify list jayegi jaha ye method call kiya hua h
		
		//covert the acount name to upperase
		convertaccountanmetouppercase(result);
		mylogger.info("\n=========> after moddify result is : "+ result);
		
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
		mylogger.info("=====> execution @Befor advice add acount");
		
		//diplay the method signature
		MethodSignature methodsignature = (MethodSignature)thejoinpoint.getSignature();
		mylogger.info("method :" + methodsignature);
		
		//display the method arguments
		
		// get args
		Object []args = thejoinpoint.getArgs();
		
		//loop the arg
		for(Object arg : args) {
			mylogger.info(arg.toString());
			if(arg instanceof Account) {
				Account theAccount = (Account)arg;
				mylogger.info("account name :" + theAccount.getName());
				mylogger.info("account level :" + theAccount.getLevel());
			}
		}
	}
	
}
