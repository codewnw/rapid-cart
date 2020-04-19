package com.rapidcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapidcart.model.Cart;
import com.rapidcart.service.CartService;

@Controller
@RequestMapping(value = "/carts")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@Transactional
	@GetMapping(value = "/{customerId}")
	public String getCart(@PathVariable("customerId") String customerId, Model model) {
		Cart cart = cartService.getCart(customerId);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@Transactional
	@GetMapping(value = "/checkout")
	public void checkout(@RequestParam("itemId") List<String> itemId) {
		System.out.println(itemId);
	}
}
