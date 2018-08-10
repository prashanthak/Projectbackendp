package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Product;

@Repository("productDao")
public interface ProductDao {
	Product saveOrUpdateProduct(Product product); 
	   Product getProduct(int id);
	   void deleteProduct(int id);
	   
	   List<Product> getAllProducts();
	   List<Product> getcatproducts(int id,String name);
}
