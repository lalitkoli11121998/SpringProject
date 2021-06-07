package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
  
	private String firstname;
	
	@NotNull(message ="is required") //agr ye null hota h then validation false hogi or message print hoga)
	@Size(min=1, max =199, message = "character out of range")
	private String lastname;
	
	
	//we override the error on the properties file if user not put integer and put string on the field. 
	@NotNull(message ="is required")
	@Min(value=0, message ="must be greater then equal to zero")
	@Max(value=10, message= "must be less then equal to 10")
	private Integer freePasses;
	
	
	@Pattern(regexp ="[a-zA-Z0-9]{5}", message ="only 5 character/digits allowed")
	private String postalCode;

	@CourseCode(value ="tops", message ="must start with tops")
	private String courseCode;
	
    public Customer() {
		
	}
    public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
