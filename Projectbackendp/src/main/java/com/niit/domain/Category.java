package com.niit.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.dao.CategoryDao;

@Entity
@Component
@Table
public class Category  {
@Id
private int cid;
private String categoryname;
@OneToMany(mappedBy="category" , fetch = FetchType.EAGER)
private List<Product> products;


public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}

public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

}
