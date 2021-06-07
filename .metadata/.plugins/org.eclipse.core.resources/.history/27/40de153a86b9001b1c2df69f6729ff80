package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//validatedBy = CourseCodeConstraintValidators.class this class will validate
//the annotation we write the business logic here
//@Target({ElementType.METHOD, ElementType.FIELD}) MEANS THIS VALIDTION WILL WORK ON FIELD AND METHOD
//@Retention(RetentionPolicy.RUNTIME) MEANS PROCESS THE ANNONATION AT RUNTIME
//@interface THIS SAYS THE CLASS IS WORK AS  ANNOTION
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//define default course code
	public String value()default "LUV"; // THIS IS THE DEFAULT VALUE OF INPUT FIELD WHERE WE APPLY ANNOTAION
	
	//DEFINE DEFAULT COURSE MESSAGE
	public String message()default "must start with LUV";
	
	//define default groups
	//CAN GROUP RELATED CONSTRAINTS
	public Class<?>[] groups() default{};
	
	//DEFINE DEFAULT PAYLOADS
	public Class<? extends Payload>[] payload() default{};

}
