package com.niit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

//Authorization
@Entity
@Component
public class Authorities {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
//@OneToOne
//private User user;
private String role;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
