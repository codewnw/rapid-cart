package com.rapidcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapidcart.model.Customer;
import com.rapidcart.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/add")
	public String createCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@Transactional
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") String id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@Transactional
	@RequestMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		if (customer.getId() == null || customer.getId().equals("")) {
			customer.setId(getCustomerId());
		}
		customerService.createOrUpdateCustomer(customer);
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@Transactional
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") String id, Model model) {
		customerService.deleteCustomer(id);
		return listCustomer(model);
	}

	@Transactional
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	private static String getCustomerId() {
		return "CUST" + System.currentTimeMillis();
	}

}
