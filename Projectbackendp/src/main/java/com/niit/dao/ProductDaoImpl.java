package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.Category;
import com.niit.domain.Customer;
import com.niit.domain.Product;

@SuppressWarnings({"deprecation","unused"})
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
		public Product saveOrUpdateProduct(Product product) {
			System.out.println("ID " + product.getId());//Transient
		    Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(product);//insert or update based on the value of Product id
		    //Persistent
		    System.out.println("ID " + product.getId());
		    return product;
		}
		public Product getProduct(int id) {//value of id=4
			Session session=sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class, id);
			//SQL - select * from product where id=4
			return product;
		}
		public void deleteProduct(int id) {
			Session session=sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class, id);
			if(product!=null)
			session.delete(product);
		}
		public List<Product> getAllProducts() {
			Session session=sessionFactory.getCurrentSession();
			//HQL - Hibernate Query Language
			//Fetch all records from Product_s190032 table
			//HQL :  "from Product" - here Product is the name of the Entity
			//SQL : select * from product -> list of product objects
			
			Query query=session.createQuery("from Product");//Product is name of the Entity
			List<Product> products=query.list();
			return products;
		}
		
		public List<Product> getcatproducts(int id,String name)
		{
			System.out.println("filtering products based on category");
			Session s=sessionFactory.getCurrentSession();			
//			String s1="from Category where cid="+id;
//			Category c=s.createQuery(s1).list().get(0);
//			Category c=(Category) s.get(Category.class, id);
//			c.getCategoryname();
			String s2="from Product where category.cid="+id;
			List<Product> plist=s.createQuery(s2).list();
			for(Product p:plist)
			{
				System.out.println(p.getName());
			}
			return plist;
		}

}
