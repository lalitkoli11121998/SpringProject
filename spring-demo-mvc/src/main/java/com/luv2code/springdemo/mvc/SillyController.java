package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	//initial controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
//		the return string is the name of the jsp html page which is rending on that requetmapping
	   return "helloworld-form";	
	}

}
