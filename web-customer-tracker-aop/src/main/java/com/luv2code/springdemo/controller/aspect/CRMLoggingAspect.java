package com.luv2code.springdemo.controller.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


import com.sun.istack.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//settup a looger
//	private Logger mylogger =
//			Logger.getLogger(getClass().getName(), null);	
	
   //setupt a pointcut
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	
	//do the same for server and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppflow() {}
	
	//add @before advice
	
	@Before("forAppflow()") // 
	//to read the parameter which pass in the pointcut methods we use joinpoint
	public void before(JoinPoint thejoinpoint) {
		System.out.println("=====> execution @Befor advice add acount");
		
		//diplay the method signature
		MethodSignature methodsignature = (MethodSignature)thejoinpoint.getSignature();
		System.out.println("method :" + methodsignature);
		
		//display the method arguments
        Object []args = thejoinpoint.getArgs();
		
		//loop the arg
		for(Object arg : args) {
			System.out.println("arguments" + arg.toString());
			
		}
		
	}

	
	//addafterReturning advice
	
	@AfterReturning(
			pointcut ="forAppflow()",
			returning ="result") //the result contain the return value of the findaccount method
	public void afterReturningFindAccountAdvice(
			JoinPoint joinpoint , Object result //this result should be match with line 22 result
			) {
		
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("=====> execution @AfterReturning advice add acount: " + method);
		
		
		//print out the result
		System.out.println("\n=========> result is : "+ result);
		
		
	}
	
	
	
}
