package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
				
		
	
			int theid =1;
			
			// start a transaction
			session.beginTransaction();
			
			//HIBERNATE QUERY WITH HQL
			//add whitespace at end of "
			Query<Instructor> qurey = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId",
					Instructor.class);
			//set paramer on query
			qurey.setParameter("theInstructorId", theid);
			
			//exeute the query
			Instructor theinstructor  = qurey.getSingleResult(); //load instructor and coures at one
			// get the instructor
			System.out.println("getting instructor: " + theinstructor);
			
		

			
			// commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//if we try to get the courses after the commit in case of lazy loading. 
			System.out.println("getting instructor coures: " + theinstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
