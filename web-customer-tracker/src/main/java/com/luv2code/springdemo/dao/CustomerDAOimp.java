package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository //THIS ANNOATION ALSO WORK SAME AS @COMPONENT ANOTAION
public class CustomerDAOimp implements CustomerDAO {

	//need to add dependency injection (session factory)
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
//	@Transactional //spring automatically transction start end or commit kregi
	public List<Customer> getCustomers() {
	   
		//get query hubernate session
		Session session = sessionFactory.getCurrentSession();
	
		//create the query and execute the query
		List<Customer> thecustomers = session.createQuery("from Customer order by lastName", 
				                                            Customer.class).getResultList();

		//return the result
		return thecustomers;
	}



	@Override
	public void saveCustomer(Customer thecustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		//saveorupdate this method check it the object has primary key then it update the record associated the primary key
		//else add new one 
		session.saveOrUpdate(thecustomer); 
	}



	@Override
	public Customer getCustomer(int theid) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Customer thecustomer = session.get(Customer.class, theid);
		return thecustomer;
	}



	@Override
	public void deleteCustomer(int thId) {
		Session session = sessionFactory.getCurrentSession();
	    Query query  = session.createQuery("delete from Customer where id = :theCustomerId");
	    query.setParameter("theCustomerId", thId);
	    query.executeUpdate();
	}



	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		 Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {
	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	        
	}

}
