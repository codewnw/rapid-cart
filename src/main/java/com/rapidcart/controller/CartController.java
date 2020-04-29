package com.rapidcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapidcart.model.Cart;
import com.rapidcart.model.Checkout;
import com.rapidcart.model.Item;
import com.rapidcart.service.CartService;
import com.rapidcart.service.ItemService;

@Controller
@RequestMapping(value = "/carts")
public class CartController {

	private final CartService cartService;

	private final ItemService itemService;

	@Autowired
	public CartController(CartService cartService, ItemService itemService) {
		this.cartService = cartService;
		this.itemService = itemService;
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
	public String checkout(@RequestParam("itemId") List<String> ids, Model model) {
		List<Item> items = itemService.getItemsByIds(ids);
		model.addAttribute("items", items);
		Checkout checkout = new Checkout();
		checkout.setIds(ids);
		model.addAttribute("checkout", checkout);
		return "checkout";
	}

	@PostMapping(value = "/place-order")
	public String placeOrder(@ModelAttribute("checkout") Checkout checkout) {
		System.out.println("Items: " + checkout.getIds());
		return "index";
	}
}
