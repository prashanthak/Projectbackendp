package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.Category;
import com.niit.domain.Product;
@SuppressWarnings({"deprecation","unused"})
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
@Autowired
private SessionFactory sessionFactory;
public Category saveOrUpdateCategory(Category category) {
	System.out.println("id"+category.getCid());//Transient
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(category);//insert or update based on the value of Category id
    //Persistent
    System.out.println("ID " + category.getCid());
    return category;
}
public Category getCategory(int id) {//value of id=4
	Session session=sessionFactory.getCurrentSession();
	Category category=(Category)session.get(Category.class, id);
	//SQL - select * from category where id=4
	return category;
}
public void deleteCategory(int id) {
	Session session=sessionFactory.getCurrentSession();
	Category category=(Category)session.get(Category.class, id);
	if(category!=null)
	session.delete(category);
}
@Override
public List<Category> getAllCategories() {
	Session session=sessionFactory.getCurrentSession();
	//HQL - Hibernate Query Language
	//Fetch all records from Category_s190032 table
	//HQL :  "from Category" - here Category is the name of the Entity
	//SQL : select * from category -> list of category objects
	
	Query query=session.createQuery("from Category");//Category is name of the Entity
	List<Category> categories=query.list();
	return categories;
}


}

