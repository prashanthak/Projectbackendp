package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Payment;

@Repository("paymentDao")
public interface PaymentDao {
	public void paymentsave(Payment payment);

	public List<Payment> getAllPayments();

	public Payment getPayment(int id);
}
