package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

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
			System.out.println("getting instructor coures: " + theinstructor.getCourses());

			
			// commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//since cours are lazy loaded or 42 line comment kr dete h this should fail if we set the eager loading then it will work fine becauuse in eager loading 
			//the theinstructor object has all the list of courses at all time. 
			
			//agr hm lazy loading rkhte h or session close hone k badd bhi courses access krna chahte h to hmko session close hone se pahle 
			 // courses fetch krvane honge taki vo memory m rahe
			//if we try to get the courses after the commit in case of lazy loading. 
			System.out.println("getting instructor coures: " + theinstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
