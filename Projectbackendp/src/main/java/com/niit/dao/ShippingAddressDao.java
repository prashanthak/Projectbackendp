package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.BillingAddress;
import com.niit.domain.ShippingAddress;

@Repository("shippingaddressDao")
public interface ShippingAddressDao {
	ShippingAddress saveOrUpdateShippingAddress(ShippingAddress shippingaddress);
	ShippingAddress getShippingAddress(int id);
	void deleteShippingAddress(int id);

	List<ShippingAddress> getAllShippingAddresses();
}
