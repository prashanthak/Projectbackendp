package com.niit.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.niit.dao.CategoryDao;

@Entity
@Component
public class Category  {
@Id
private int cid;
private String categoryname;
//@OneToMany(mappedBy="category")
//private List<Product>  products;
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
