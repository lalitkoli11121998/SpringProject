package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//CREATE SESSION-FACTORY
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml") //this is option if you are not given path the hibernate khud search kr leta h project m
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		//create the session
		Session session = factory.getCurrentSession();
		try {

			
			//start the transaction
			session.beginTransaction();
			
			//qeury students
			List<Student>li  = session.createQuery("from Student").getResultList();
			
			//display the students
			System.out.println("qury result1");
			printresult(li);
			
		   //print all student where lastname is agarwal
			                                      //here we are using object and its field name not table or its column name
            List<Student>l2  = session.createQuery("from Student s where s.lastname='agarwal'").getResultList();
			
			//display the students
            System.out.println("qury result2");
			printresult(l2);
			
			//print all student where lastname is agarwal or first name arjun
            //here we are using object and its field name not table or its column name
            List<Student>l3  = session.createQuery("from Student s where"
        		  +" s.lastname='agarwal' OR s.firsname='pavi' ").getResultList();

            //display the students
            System.out.println("qury result3");
            printresult(l3);
            
			//print all student where lastname is agarwal or first name arjun
            //here we are using object and its field name not table or its column name
            List<Student>l4  = session.createQuery("from Student s where"
        		  +" s.email like '%kavi%' ").getResultList();

            //display the students
            System.out.println("qury result4");
            printresult(l4);
			
			session.getTransaction().commit();
			
			System.out.println("done");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}

	private static void printresult(List<Student> l2) {
		for(Student st :l2) {
			System.out.println(st);
		}
	}

}
