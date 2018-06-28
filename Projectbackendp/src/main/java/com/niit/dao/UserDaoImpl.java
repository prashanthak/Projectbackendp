package com.niit.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.domain.User;

@SuppressWarnings({"deprecation","unused"})
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public User saveOrUpdateUser(User user) {
		System.out.println("ID " + user.getId());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(user);//insert or update based on the value of User id
	    //Persistent
	    System.out.println("ID " + user.getId());
	    return user;
	}
	public User getUser(int id) {//value of id=4
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, id);
		//SQL - select * from user where id=4
		return user;
	}
	public void deleteUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, id);
		if(user!=null)
		session.delete(user);
	}
	public List<User> getAllUsers() {
		Session session=sessionFactory.getCurrentSession();
		//HQL - Hibernate Query Language
		//Fetch all records from User_s190032 table
		//HQL :  "from User" - here User is the name of the Entity
		//SQL : select * from user -> list of user objects
		
		Query query=session.createQuery("from User");//User is name of the Entity
		List<User> user=query.list();
		return user;
	}

}
