package com.rapidcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.CustomerDao;
import com.rapidcart.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Long createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer getCustomer(String id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public void createOrUpdateCustomer(Customer customer) {
		customerDao.createOrUpdateCustomer(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		customerDao.deleteCustomer(id);
	}

}
