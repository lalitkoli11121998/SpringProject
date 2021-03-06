package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//retrieve the object 
			//ye bs yha pr primary key hi let h as where clause
			Student st = session.get(Student.class, studentid);
		
			//delete the object
			session.delete(st);
			
			//commit the transaction
			session.getTransaction().commit();
			
//			delete using query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student s where s.id =7").executeUpdate();
			
			
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
