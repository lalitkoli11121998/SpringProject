package com.luv2code.springdemo.dao;
import java.util.List;
import com.luv2code.springdemo.entity.Customer;
public interface CustomerDAO {
	
	public List<Customer>getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theid);

	public void deleteCustomer(int thId);

	public List<Customer> searchCustomers(String theSearchName);

}
