package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.Payment;
@SuppressWarnings({"deprecation","unused"})
@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PaymentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void paymentsave(Payment payment) {
		 Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPayment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

