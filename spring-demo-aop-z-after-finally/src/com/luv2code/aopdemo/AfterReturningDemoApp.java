package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MemberShipDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
       
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring container
		AccountDao theaccountdao = context.getBean("accountDao",AccountDao.class );
		
		List<Account>mylist = theaccountdao.findAccount(true);
		
		//display the acconts
		System.out.println("\n\nMain Program : AfterRetuningDemoApp");
		System.out.println("---");
		System.out.println(mylist);

		//close the context
		context.close();
	}

}
