package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//this class validate the annotation data
public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode, String>{
     
	private String coursePrefix; //we will validate against 
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	//thecode is the actual data which user add in input
	//theconstraintValidatorContext you can place additonal error message to using this
	@Override
	public boolean isValid(String thecode, ConstraintValidatorContext theconstraintValidatorContext) {
		// TODO Auto-generated method stub
		boolean result;
		
		if(thecode != null) {
			result = thecode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		thecode.startsWith(coursePrefix);
		
		return result;
	}

}
