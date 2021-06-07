package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		//CREATE SESSION-FACTORY
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml") //this is option if you are not given path the hibernate khud search kr leta h project m
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		//create the session
		Session session = factory.getCurrentSession();
		try {
			//use the session object
		   //create the student object
			System.out.println("create the student objects...");
			Student student1 = new Student("harish","agarwal","harish@gmail.com");
			Student student2 = new Student("joshn","tom","johntom@gmail.com");
			Student student3 = new Student("pavi","khnna","pavi@gmail.com");
			//start the transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("saving the object.....");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}
}

