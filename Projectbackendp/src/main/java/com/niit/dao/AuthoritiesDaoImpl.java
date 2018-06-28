//package com.niit.dao;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.niit.domain.Authorities;
//import com.niit.domain.Category;
//
//@SuppressWarnings({"deprecation","unused"})
//@Repository("authoritiesDao")
//@Transactional
//public class AuthoritiesDaoImpl implements AuthoritiesDao {
//	@Autowired
//	private SessionFactory sessionFactory;
//	public Authorities saveOrUpdateAuthorities(Authorities authorities) {
//		System.out.println("id"+authorities.getId());//Transient
//		Session session=sessionFactory.getCurrentSession();
//		session.saveOrUpdate(authorities);//insert or update based on the value of Authorities id
//	    //Persistent
//	    System.out.println("ID " + authorities.getId());
//	    return authorities;
//	}
//	public Authorities getAuthorities(int id) {//value of id=4
//		Session session=sessionFactory.getCurrentSession();
//		Authorities authorities=(Authorities)session.get(Authorities.class, id);
//		//SQL - select * from category where id=4
//		return authorities;
//	}
//	public void deleteAuthorities(int id) {
//		Session session=sessionFactory.getCurrentSession();
//		Authorities authorities=(Authorities)session.get(Authorities.class, id);
//		if(authorities!=null)
//		session.delete(authorities);
//	}
//	public List<Authorities> getAllAuthorities1() {
//		Session session=sessionFactory.getCurrentSession();
//		//HQL - Hibernate Query Language
//		//Fetch all records from Authorities_s190032 table
//		//HQL :  "from Authorities" - here Authorities is the name of the Entity
//		//SQL : select * from authorities -> list of authorities objects
//		
//		Query query=session.createQuery("from Authorities");//Authorities is name of the Entity
//		List<Authorities> authorities=query.list();
//		return authorities;
//	}
//
//	@Override
//	public List<Authorities> getAllAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
