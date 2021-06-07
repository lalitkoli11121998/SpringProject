package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBservlet
 */
@WebServlet("/TestDBservlet")
public class TestDBservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	//setup connection variable
		String user = "springstudent";
		String pass = "springstudent";
		String jdburl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL= false";
		String driver = "com.mysql.cj.jdbc.Driver"; //kyoki hm servlet use kr rhe h to hme yha driver ka path dena hoga
	    try {
	    	PrintWriter out = response.getWriter();
	    	out.println("connecting to database:"+ jdburl);
	    	Class.forName(driver);
	    	
	    	Connection mycon = DriverManager.getConnection(jdburl, user, pass);
	    	out.println("success!!");
	    	mycon.close();
	    	
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	throw new ServletException(ex);
	    }
	//get connection
	}

}
