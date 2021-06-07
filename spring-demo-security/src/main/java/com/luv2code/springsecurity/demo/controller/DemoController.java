package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
//@RequestMapping("")
public class DemoController {

	
//	@GetMapping("/")
	@RequestMapping(path ="/", method = RequestMethod.GET)
	public String gethome() {
		
		return "home";
		
	}
}
