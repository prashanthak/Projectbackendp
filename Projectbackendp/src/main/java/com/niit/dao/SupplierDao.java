package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Supplier;
@Repository
public interface SupplierDao {
	Supplier saveOrUpdateSupplier(Supplier supplier);
	Supplier getSupplier(int sid);
	void deleteSupplier(int sid);
	
	List<Supplier> getAllSuppliers();

}
