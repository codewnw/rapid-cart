package com.rapidcart.dao;

import java.util.List;

import com.rapidcart.model.Customer;

public interface CustomerDao {

	Long createCustomer(Customer customer);

	Customer getCustomer(String id);

	List<Customer> getCustomers();

	void createOrUpdateCustomer(Customer customer);

	void deleteCustomer(String id);

}
