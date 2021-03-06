package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MemberShipDao;

public class MainDemoApp {

	public static void main(String[] args) {
       
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring container
		AccountDao theaccountdao = context.getBean("accountDao",AccountDao.class );
		
		//get membershp ben from spring container
		MemberShipDao theMemberShipDao = context.getBean("memberShipDao",MemberShipDao.class );

		
		//call the business method
		Account account = new Account();
		theaccountdao.addAccout(account, true);
		theaccountdao.dowork();
		
		//call the memebership business method
		theMemberShipDao.addAccoutformember();
		theMemberShipDao.gotosleep();
		
//		//call it again to check firse before method isse pahle run hota h ki nhi
//		System.out.println("run it again");
//		theaccountdao.addAccout();
		//close the context
		context.close();
	}

}
