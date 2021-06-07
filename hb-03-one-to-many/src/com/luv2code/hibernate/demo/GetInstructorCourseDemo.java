package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorCourseDemo {

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
			
			// get the instructor
			Instructor theinstructor = session.get(Instructor.class, theid);
			System.out.println("getting instructor: " + theinstructor);
			
			
	        //get the courses along with the instructor
			//the is eager loading not lazy loading it will always fetch the all courses belong the instructor
			System.out.println("getting instructor coures: " + theinstructor.getCourses());

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
