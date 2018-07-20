package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.BillingAddress;
import com.niit.domain.Product;
@SuppressWarnings({"deprecation","unused"})
@Repository("billingaddressDao")
@Transactional
public class BillingAddressDaoImpl implements BillingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;
	public BillingAddress saveOrUpdateBillingAddress(BillingAddress billingaddress) {
		System.out.println("ID " + billingaddress.getId());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(billingaddress);//insert or update based on the value of Product id
	    //Persistent
	    System.out.println("ID " + billingaddress.getId());
	    return billingaddress;
	}
	public BillingAddress getProduct(int id) {//value of id=4
		Session session=sessionFactory.getCurrentSession();
		BillingAddress billingaddress=(BillingAddress)session.get(BillingAddress.class, id);
		//SQL - select * from billingaddress where id=4
		return billingaddress;
	}
	public void deletebillingaddress(int id) {
		Session session=sessionFactory.getCurrentSession();
		BillingAddress billingaddress=(BillingAddress)session.get(BillingAddress.class, id);
		if(billingaddress!=null)
		session.delete(billingaddress);
	}
	public List<BillingAddress> getAllBillingAddresses() {
		Session session=sessionFactory.getCurrentSession();
		//HQL - Hibernate Query Language
		//Fetch all records from BillingAddress_s190032 table
		//HQL :  "from BillingAddress" - here BillingAddress is the name of the Entity
		//SQL : select * from product -> list of product objects
		
		Query query=session.createQuery("from BillingAddress");//BillingAddress is name of the Entity
		List<BillingAddress> billingaddresses=query.list();
		return billingaddresses;
	}
	@Override
	public BillingAddress getBillingAddress(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteBillingAddress(int id) {
		// TODO Auto-generated method stub
		
	}

}
