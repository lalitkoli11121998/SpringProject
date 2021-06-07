package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpression {

	
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create point cut for setter method
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}

	//create point cut for getter method
	@Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create the combine pointcut
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDaoPackageNogettersetter() {}


}

