package com.niit.dao;

import java.util.List;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.CustomerOrder;
import com.niit.domain.Product;
@Repository("customerOrderDao")
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {
	@Autowired
	private SessionFactory sessionFactory;
		public CustomerOrder saveOrUpdateCustomerOrder(CustomerOrder customerorder) {
			System.out.println("ID " + customerorder.getOrderId());//Transient
		    Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(customerorder);//insert or update based on the value of Product id
		    //Persistent
		    System.out.println("ID " + customerorder.getOrderId());
		    return customerorder;
		}
		public CustomerOrder getCustomerOrder(int id) {//value of id=4
			Session session=sessionFactory.getCurrentSession();
			CustomerOrder customerorder=(CustomerOrder)session.get(CustomerOrder.class, id);
			//SQL - select * from product where id=4
			return customerorder;
		}
		public void deleteCustomerOrder(int id) {
			Session session=sessionFactory.getCurrentSession();
			CustomerOrder customerorder=(CustomerOrder)session.get(CustomerOrder.class, id);
			if(customerorder!=null)
			session.delete(customerorder);
		}
		public List<CustomerOrder> getAllCustomerOrders() {
			Session session=sessionFactory.getCurrentSession();
			//HQL - Hibernate Query Language
			//Fetch all records from Product_s190032 table
			//HQL :  "from Product" - here Product is the name of the Entity
			//SQL : select * from product -> list of product objects
			
			Query query=session.createQuery("from CustomerOrder");//Product is name of the Entity
			List<CustomerOrder> customerorders=query.list();
			return customerorders;
		}
		
		
		
		


}
