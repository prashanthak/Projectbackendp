package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Customer;

@Repository("customerDao")
public interface CustomerDao {
	Customer saveOrUpdateCustomer(Customer customer);
	
	Customer getCustomer(int id);
	void deleteCustomer(int id);
	
	List<Customer> getAllCustomers();

	boolean isEmailUnique(String email);

}
