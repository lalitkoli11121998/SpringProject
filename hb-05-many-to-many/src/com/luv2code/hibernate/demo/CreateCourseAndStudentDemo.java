package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int thid =1;
			// start a transaction
			session.beginTransaction();
			//get the student kavi from database
			Student thest = session.get(Student.class, thid);
			System.out.println("getting student"+ thest);
			System.out.println("getting student"+ thest.getCourses());
			
			//create one more course
			Course tempCourse1 = new Course("java course is best");
			Course tempCourse2 = new Course("c++ basic course is best");
			
           //add student to the course
			tempCourse1.addStudent(thest);
			tempCourse2.addStudent(thest);
			System.out.println("SAVING THE COURSE...");

			
			//save the cousre
			session.save(tempCourse1);
			session.save(tempCourse2);
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





