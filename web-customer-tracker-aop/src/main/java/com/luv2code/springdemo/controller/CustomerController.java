package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImp;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	//need to inject customerservice
	@Autowired
//	private CustomerDAO customerDAO;
	private CustomerService customerService;
	
	
//	@RequestMapping("/list")
	@GetMapping(path ="/list")
//	@RequestMapping(path ="/list", method = RequestMethod.PATCH)
	public String listCustomers(Model model) {
		
		//GET CUSTOMER FROM THE service
		List<Customer>thecustomer = customerService.getCustomers();
		
		//ADD THE CUSTOMER TO THE MODEL
		model.addAttribute("customers", thecustomer);
		return "list-customers";
	}
	
	
	
	@RequestMapping(path ="/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		//create model attribut to bind form data
		Customer thecustomer = new Customer();
		model.addAttribute("customer", thecustomer);
		return "customer-form";
	}
	
	
	
	@RequestMapping(path ="/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		//create model attribut to bind form data
//		Customer thecustomer = new Customer();
//		
//		model.addAttribute("customer", thecustomer);
		customerService.saveCustomer(thecustomer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping(path ="/showFormForUpdate", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("customerId")int thId, Model theModel) {
		
		//get the customer form service (service)
		Customer thecustomer  = customerService.getCustomer(thId);
		
		//set the customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer",thecustomer);
		
		//send over to our form
		
		return "customer-form";
	}
	@RequestMapping(path ="/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("customerId")int thId) {
		
		//delete customer form service (service)
		 customerService.deleteCustomer(thId);
		
		 return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";        
    }
}
