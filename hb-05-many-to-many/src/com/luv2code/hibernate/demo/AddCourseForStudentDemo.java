package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForStudentDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			
			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			//save the course
			System.out.println("saving the course...");
			session.save(tempCourse);
			System.out.println("saved course..."+ tempCourse);
			
			//create the students
			Student st1 = new Student("kavi","agrwal","kavi@gmail.com");
			Student st2 = new Student("rahul","kohli","rahul@gmail.com");
			Student st3 = new Student("mayank","agrwal","mayak@gmail.com");
			
			//add student to the course
			tempCourse.addStudent(st1);
			tempCourse.addStudent(st2);
			tempCourse.addStudent(st3);

			//save the students
			System.out.println("saving the student ...");
			session.save(st1);
			session.save(st2);
			session.save(st3);
			System.out.println("saved student ..." + tempCourse.getStudents());
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





