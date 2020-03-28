package com.rapidcart.service;

import java.util.List;

import com.rapidcart.model.Customer;

public interface CustomerService {

	Long createCustomer(Customer customer);

	Customer getCustomer(String id);

	List<Customer> getCustomers();

	void createOrUpdateCustomer(Customer customer);

	void deleteCustomer(String id);

}
