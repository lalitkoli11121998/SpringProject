package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //this is parent mapping
public class HelloWorldController {

	//initial controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
//		the return string is the name of the jsp html page which is rending on that requetmapping
	   return "helloworld-form";	
	}
	
	//need a controller  method to process the html form
	@RequestMapping("/processForm")
	public String precesform() {
		return "helloworld";	
	}
	//new controller which read form data nad 
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutdude(HttpServletRequest request, Model model) {
		//READ THE REQUEST PARM FOR THE REQEUST
		String thname = request.getParameter("studentName");
		
		thname = thname.toUpperCase();
		String result = "yO! " + thname;
		model.addAttribute("message", thname);
		return "helloworld";	
	}
	@RequestMapping("/processFormVersionThree")
	public String letsShoutdude2(@RequestParam("studentName")String thname, Model model) {
		//READ THE REQUEST PARM FOR THE REQEUST

		
		thname = thname.toUpperCase();
		String result = "yOyo! " + thname;
		model.addAttribute("message", thname);
		return "helloworld";	
	}
}
