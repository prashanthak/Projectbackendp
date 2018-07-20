//package com.niit.dao;
//
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.niit.domain.Feedback;
//import com.niit.domain.Supplier;
//@SuppressWarnings({"deprecation","unused"})
//@Repository("feedbackDao")
//@Transactional
//public class FeedbackDaoImpl implements FeedbackDao{
//	@Autowired
//	private SessionFactory sessionFactory;
////		public Feedback saveOrUpdateFeedback(Feedback feedback) {
////			System.out.println("ID " + feedback.getFeed());//Transient
////		    Session session=sessionFactory.getCurrentSession();
////		    session.saveOrUpdate(feedback);//insert or update based on the value of Supplier id
////		    //Persistent
////		    System.out.println("ID " + feedback.getFeed());
////		    return feedback;
////		}
//		public Feedback getFeedback(int id) {//value of id=4
//			Session session=sessionFactory.getCurrentSession();
//			Feedback feedback=(Feedback)session.get(Feedback.class, id);
//			//SQL - select * from supplier where id=4
//			return feedback;
//		}
//		public void deleteSupplier(int id) {
//			Session session=sessionFactory.getCurrentSession();
//			Supplier supplier=(Supplier)session.get(Supplier.class, id);
//			if(supplier!=null)
//			session.delete(supplier);
//		}
////		public List<Supplier> getAllSupplier() {
////			Session session=sessionFactory.getCurrentSession();
////			//HQL - Hibernate Query Language
////			//Fetch all records from Supplier_s190032 table
////			//HQL :  "from Supplier" - here Supplier is the name of the Entity
////			//SQL : select * from supplier -> list of supplier objects
////			
////			Query query=session.createQuery("from Feedback");//Supplier is name of the Entity
////			List<Feedback> feedbacks=query.list();
////			return feedbacks;
////		}
////		@Override
////		public Feedback saveOrUpdateFeedback(Feedback feedback) {
////			// TODO Auto-generated method stub
////			return null;
////		}
////		@Override
////		public List<Feedback> getAllFeedbacks() {
////			// TODO Auto-generated method stub
////			return null;
//	//	}
//		@Override
//		public boolean save(Feedback feedback) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		@Override
//		public List<Feedback> feedlist() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public List<Feedback> somefeed() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//}
//
//	
//	
//	
//
