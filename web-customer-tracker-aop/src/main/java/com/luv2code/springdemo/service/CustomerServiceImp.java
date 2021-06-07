package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.dao.CustomerDAOimp;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}



	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		customerDAO.saveCustomer(thecustomer);
	}



	@Override
	@Transactional
	public Customer getCustomer(int theid) {
		return customerDAO.getCustomer(theid);
	}



	@Override
	@Transactional
	public void deleteCustomer(int thId) {
		customerDAO.deleteCustomer(thId);		
	}



	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

}
