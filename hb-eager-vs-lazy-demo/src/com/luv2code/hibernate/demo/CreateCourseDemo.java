package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

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
			
			//create the courses
		    Course thecourse1 = new Course("english coaching");
		    Course thecourse2 = new Course("java coaching");
		    Course thecourse3 = new Course("hibernate coaching");
		    
		    //add course in the insturctor
		    theinstructor.add(thecourse3);
		    theinstructor.add(thecourse2);
		    theinstructor.add(thecourse1);
		    
		    //save the coureses
		    session.save(thecourse1);
		    session.save(thecourse2);
		    session.save(thecourse3);
			//System.out.println("Saving instructor: " + tempInstructor);
			//session.save(tempInstructor);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
