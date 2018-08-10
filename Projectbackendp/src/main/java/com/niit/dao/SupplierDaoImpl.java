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
		
		@Override
		public Supplier saveOrUpdateSupplier(Supplier supplier) {
			System.out.println("ID " + supplier.getSid());//Transient
		    Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(supplier);//insert or update based on the value of Supplier id
		    //Persistent
		    System.out.println("ID " + supplier.getSid());
		    return supplier;
			
		}
		@Override
		public List<Supplier> getAllSuppliers() {
			Session session=sessionFactory.getCurrentSession();
			
			Query query=session.createQuery("from Supplier");//Supplier is name of the Entity
			List<Supplier> suppliers=query.list();
			return suppliers;
			
		}
		public Supplier getByName(String name)
		{
			String hql = " from Supplier where suppliername = " + "'" + name + "'";
			
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Supplier> listSupplier = query.list();
			
			if(listSupplier!=null || !listSupplier.isEmpty())
			{
				return listSupplier.get(0);
			}
			return null;
		}

}


