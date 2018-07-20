package com.niit.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
//Authentication
@Entity
@Component
public class User implements Serializable {

 @Id
 private String  email;
 private String password;
 private boolean enabled;
// @OneToOne(mappedBy="user",cascade=CascadeType.ALL)
// private Authorities authorities;
 @OneToOne(mappedBy="user")
 private Customer customer;
 private String role;
public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getEmail() {
	return email;
}



public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}


}
