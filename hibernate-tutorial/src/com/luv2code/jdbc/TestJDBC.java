package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// jdbc:mysql://<ip address of the connection> :<port number> / <database name>;
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String username = "hbstudent";
		String password = "hbstudent";
	  try {
		  System.out.println("connecting to mysql" + jdbcurl);
		  Connection mycon = DriverManager.getConnection(jdbcurl,username,password);
		  System.out.println("connecting to mysql");
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }

	}

}
