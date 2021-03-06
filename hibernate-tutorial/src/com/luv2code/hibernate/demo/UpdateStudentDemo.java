package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//CREATE SESSION-FACTORY
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml") //this is option if you are not given path the hibernate khud search kr leta h project m
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		//create the session
		Session session = factory.getCurrentSession();
		try {
			int studentid = 1;
		
		    session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("getting student with id: " + studentid);
			
			Student st = session.get(Student.class, studentid);
			st.setFirsname("dinesh");
			//commit the transaction
			session.getTransaction().commit();
			
			//update using query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.email ='buddu@gmail.com'").executeUpdate();
			
			
			
			
			
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
