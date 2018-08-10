package com.niit.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CustomerOrder {
	//ADD CustomerOrder.class in DBConfiguration.java class}
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private Date purchaseDate;
	private double grandTotal;
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	public int getOrderId() {
		return orderId;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	}