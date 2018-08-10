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
import com.niit.domain.ShippingAddress;
@SuppressWarnings({"deprecation","unused"})
@Repository("shippingaddressDao")
@Transactional
public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public ShippingAddress saveOrUpdateShippingAddress(ShippingAddress shippingaddress) {
		System.out.println("ID " + shippingaddress.getId());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(shippingaddress);//insert or update based on the value of Product id
	    //Persistent
	    System.out.println("ID " + shippingaddress.getId());
		return shippingaddress;
	}

	@Override
	public ShippingAddress getShippingAddress(int id) {
		Session session=sessionFactory.getCurrentSession();
		ShippingAddress shippingaddress=(ShippingAddress)session.get(ShippingAddress.class, id);
		//SQL - select * from product where id=4
		return shippingaddress;
	}

	@Override
	public void deleteShippingAddress(int id) {
		Session session=sessionFactory.getCurrentSession();
		ShippingAddress shippingaddress=(ShippingAddress)session.get(ShippingAddress.class, id);
		if(shippingaddress!=null)
		session.delete(shippingaddress);
	}

	@Override
	public List<ShippingAddress> getAllShippingAddresses() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ShippingAddress");//BillingAddress is name of the Entity
		List<ShippingAddress> shippingaddress=query.list();
		return shippingaddress;
	}

}
