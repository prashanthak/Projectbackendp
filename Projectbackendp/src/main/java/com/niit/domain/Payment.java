package com.niit.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	private String Streetaddrs;
	private String city;
	private int zip;
	private int mob;
	private String payemail;
	private String payfnam;
	private String paylname;
	private String paycardno;
	private String cvv;
	private String cardexpirydate;
	
	private String pay_datetime;

	public Payment() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		pay_datetime = dateFormat.format(date);
		
		System.out.println("Paid at : " + pay_datetime);
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getStreetaddrs() {
		return Streetaddrs;
	}

	public void setStreetaddrs(String streetaddrs) {
		Streetaddrs = streetaddrs;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getMob() {
		return mob;
	}

	public void setMob(int mob) {
		this.mob = mob;
	}

	public String getPayemail() {
		return payemail;
	}

	public void setPayemail(String payemail) {
		this.payemail = payemail;
	}

	public String getPayfnam() {
		return payfnam;
	}

	public void setPayfnam(String payfnam) {
		this.payfnam = payfnam;
	}

	public String getPaylname() {
		return paylname;
	}

	public void setPaylname(String paylname) {
		this.paylname = paylname;
	}

	public String getPaycardno() {
		return paycardno;
	}

	public void setPaycardno(String paycardno) {
		this.paycardno = paycardno;
	}

	

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardexpirydate() {
		return cardexpirydate;
	}

	public void setCardexpirydate(String cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}

	public String getPay_datetime() {
		return pay_datetime;
	}

	public void setPay_datetime(String pay_datetime) {
		this.pay_datetime = pay_datetime;
	}
}
