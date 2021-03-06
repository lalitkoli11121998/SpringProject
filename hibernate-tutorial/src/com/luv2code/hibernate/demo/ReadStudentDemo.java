package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			System.out.println("create the student object");
			Student student = new Student("rahul","agarwal","arjun@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("saving the object");
			session.save(student);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//retrieve the student, find the student's id:primary key
			System.out.println("saved student and generated id: " + student.getId());
			
			//now get a new session and start transaction
		    session = factory.getCurrentSession();
		    session.beginTransaction();
		    
		    //retrieve the student based on the id: primary key:id
			System.out.println("getting student with id: " + student.getId());
			
			Student student1 = session.get(Student.class, student.getId());
			System.out.println("get complete :" + student1);
			
			//commit
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
