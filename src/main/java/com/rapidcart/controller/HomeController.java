package com.rapidcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rapidcart.model.Item;
import com.rapidcart.service.ItemService;

@Controller
public class HomeController {

	private final ItemService itemService;

	@Autowired
	public HomeController(ItemService itemService) {
		this.itemService = itemService;
	}

	@Transactional
	@GetMapping("/")
	public String home(Model model) {
		List<Item> items = itemService.getItems();
		model.addAttribute("items", items);
		return "index";
	}

	@GetMapping("/contact")
	public String contact() {
		int i = 10 / 0;
		return "contact";
	}

}
