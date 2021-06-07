package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	//get mapping for /leaders
	
	@GetMapping("/leaders")
	public String showleaders() {
		
		return "leaders";
	}
	
	
	@GetMapping("/admins")
	public String showadmins() {
		
		return "admins";
	}
	
	
	
	
	
	
	
}
