package com.niit.dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import com.niit.domain.Customer;
import com.niit.domain.CustomerOrder;

@Repository("customerOrderDao")
public interface CustomerOrderDao {
CustomerOrder saveOrUpdateCustomerOrder(CustomerOrder customerorder);
	
CustomerOrder getCustomerOrder(int id);
void deleteCustomerOrder(int id);
	List<CustomerOrder> getAllCustomerOrders();

	
}
