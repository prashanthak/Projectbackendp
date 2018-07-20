package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.Product;
import com.niit.domain.Supplier;

@SuppressWarnings({"deprecation","unused"})
@Repository("SupplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	private SessionFactory sessionFactory;
		public Supplier saveOrUpdateProduct(Supplier supplier) {
			System.out.println("ID " + supplier.getSid());//Transient
		    Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(supplier);//insert or update based on the value of Supplier id
		    //Persistent
		    System.out.println("ID " + supplier.getSid());
		    return supplier;
		}
		public Supplier getSupplier(int id) {//value of id=4
			Session session=sessionFactory.getCurrentSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, id);
			//SQL - select * from supplier where id=4
			return supplier;
		}
		public void deleteSupplier(int id) {
			Session session=sessionFactory.getCurrentSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, id);
			if(supplier!=null)
			session.delete(supplier);
		}
		public List<Supplier> getAllSupplier() {
			Session session=sessionFactory.getCurrentSession();
			//HQL - Hibernate Query Language
			//Fetch all records from Supplier_s190032 table
			//HQL :  "from Supplier" - here Supplier is the name of the Entity
			//SQL : select * from supplier -> list of supplier objects
			
			Query query=session.createQuery("from Supplier");//Supplier is name of the Entity
			List<Supplier> suppliers=query.list();
			return suppliers;
		}
		@Override
		public Supplier saveOrUpdateSupplier(Supplier supplier) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Supplier> getAllSuppliers() {
			// TODO Auto-generated method stub
			return null;
		}

}


