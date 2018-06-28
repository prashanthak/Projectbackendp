package com.niit.Projectbackendp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;

public class Categorytestcase {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
	config.scan("com.niit");
	config.refresh();
	Category category=(Category)config.getBean("Category");
	
	CategoryDao categoryDao=(CategoryDao)config.getBean("categoryDao");
	
	category.setCid(1);
	category.setCategoryname("Electronics");
	categoryDao.saveOrUpdateCategory(category);
}
}
