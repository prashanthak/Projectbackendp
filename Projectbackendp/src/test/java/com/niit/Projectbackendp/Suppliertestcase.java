package com.niit.Projectbackendp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.domain.Supplier;

public class Suppliertestcase {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		Supplier supplier=(Supplier)config.getBean("supplier");
		
		SupplierDao supplierDao=(SupplierDao)config.getBean("supplierDao");
		
		supplier.setSid(1);
		supplier.setSuppliername("Bangalore");
		supplierDao.saveOrUpdateSupplier(supplier);
		
	}

}
