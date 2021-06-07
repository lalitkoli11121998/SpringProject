package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects
			
//			Instructor tempInstructor = 
//					new Instructor("kavita", "agarwal", "kavi@luv2code.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail(
//							"http://www.luv2code.com/youtube/4//5",
//							"Luv 2 code no!!!");		
		
//			tempInstructorDetail.setInstrutor(tempInstructor);
			
			// start a transaction
			session.beginTransaction();
			int thid =9;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, thid);
			//
			instructorDetail.getInstrutor();
			
		
			System.out.println("Saving instructor: " + instructorDetail);
			System.out.println("Saving instructor: " + instructorDetail.getInstrutor());				
			
			// commit transaction
			
			System.out.println("deleting: " + instructorDetail);
			
			//remove the associated object refernece 
			//break bi-directional link
			instructorDetail.getInstrutor().setInstructorDetail(null);
			session.delete(instructorDetail);
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
