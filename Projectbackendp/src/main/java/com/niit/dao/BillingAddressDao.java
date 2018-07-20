package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.BillingAddress;

@Repository("billingaddressDao")
public interface BillingAddressDao {
BillingAddress saveOrUpdateBillingAddress(BillingAddress billingaddress);
BillingAddress getBillingAddress(int id);
void deleteBillingAddress(int id);

List<BillingAddress> getAllBillingAddresses();
}
