package com.niit.Projectbackendp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;


public class Producttestcase {
	public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
	config.scan("com.niit");
	config.refresh();
	Product product=(Product)config.getBean("product");
	
	ProductDao productDao=(ProductDao)config.getBean("productDao");
	
	product.setId(1);
	product.setName("Laptop");
	product.setDescription("user friendly");
	product.setPrice(35000);
	product.setQuantity(2);
	productDao.saveOrUpdateProduct(product);
}
}
