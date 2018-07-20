package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.Customer;
import com.niit.domain.Product;
import com.niit.domain.User;

@SuppressWarnings({"deprecation","unused"})
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
		
		
		public void deleteCustomer(int id) {
			Session session=sessionFactory.getCurrentSession();
			Customer customer=(Customer)session.get(Customer.class, id);
			if(customer!=null)
			session.delete(customer);
		}
		public List<Customer> getAllCustomers() {
			Session session=sessionFactory.getCurrentSession();
			//HQL - Hibernate Query Language
			//Fetch all records from Customer_s190032 table
			//HQL :  "from Customer" - here Customer is the name of the Entity
			//SQL : select * from customer -> list of customer objects
			
			Query query=session.createQuery("from Customer");//Customer is name of the Entity
			List<Customer> customers=query.list();
			return customers;
		}
		@Override
		public Customer saveOrUpdateCustomer(Customer customer) {
			System.out.println("ID " + customer.getId());//Transient
		    Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(customer);//insert or update based on the value of Customer id
		    //Persistent
		    System.out.println("ID " + customer.getId());
		    return customer;
		
		}
		@Override
		public Customer getCustomer(int id) {
			Session session=sessionFactory.getCurrentSession();
			Customer customer=(Customer)session.get(Customer.class, id);
			//SQL - select * from customer where id=4
			return customer;
			
		}
		@Override
		public boolean isEmailUnique(String email) {
			Session session=sessionFactory.getCurrentSession();
			String s="from User where email='"+email+"'";
			Query q=session.createQuery(s);
			List<User> ulist=q.list();
			System.out.println(ulist.size());
			//User u=ulist.get(0);
//			User u=(User) session.createCriteria(User.class, email);
//		Customer c=(Customer)session.get(Customer.class, u);
//			
			if(ulist.size()!=0)
			return false;
			else
				return true;
		}


}
