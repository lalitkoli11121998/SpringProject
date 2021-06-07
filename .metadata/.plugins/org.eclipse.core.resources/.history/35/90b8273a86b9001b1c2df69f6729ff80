package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
@RequestMapping("/customer")
public class CustomerController {

	//add initbinder ....who process every web request 
	//add strngTrimerEditor class which is inbulit spring api class
	//we are using stringtrimEditor to remove tralling and leading space in the string data
	// which are coming through the request
	//add true to the constructor so that if whole string is whitespace then spring convert it into null
	
	@InitBinder
	public void initbinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringtimeerEditor = new StringTrimmerEditor(true);
	    dataBinder.registerCustomEditor(String.class, stringtimeerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model thmodel) {
		thmodel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	//we have to tell spring that validate the coming customer object, TO DO SO SPRING USE @Valid annotation
	//bindng result contatin the result of validation
	public String processForm(
			@Valid @ModelAttribute("customer")Customer customer , BindingResult thebindingResult ) {
		
		System.out.println(customer.getLastname());
		//check the incoming object has error
		System.out.println("bindingresult" +  thebindingResult);
		if(thebindingResult.hasErrors()) {
			return "custmer-form";
		}else {
			return "custmer-confirmation";	
		}
		
		
	}
}
