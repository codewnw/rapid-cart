package com.rapidcart.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.rapidcart.dao.CartDaoImpl;
import com.rapidcart.model.Cart;

@Controller
public class HomeController {

	@Autowired
	private CartDaoImpl cartDaoImpl;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@Transactional
	@GetMapping("/cart")
	public void cart() {
		Set<String> items = new HashSet<>();
		items.add("one");
		items.add("Two");
		items.add("Three");
		Cart cart = new Cart("2", items);
		cartDaoImpl.createCustomer(cart);
	}

}
