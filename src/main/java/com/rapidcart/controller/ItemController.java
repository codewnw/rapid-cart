package com.rapidcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rapidcart.model.Customer;
import com.rapidcart.model.Item;
import com.rapidcart.service.ItemService;



@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/add")
	public String createItem(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "add-item";
	}
	
	@Transactional
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") String id, Model model) {
		Item item = itemService.getItem(id);
		model.addAttribute("item", item);
		return "add-item";
	}
	
	@Transactional
	@RequestMapping("/save")
	public String saveItem(@ModelAttribute("item") Item item, Model model) {
		if (item.getId() == null || item.getId().equals("")) {
			item.setId(getItemId());
		}
		itemService.createOrUpdateItem(item);
		List<Item> items = itemService.getItems();
		model.addAttribute("items", items);
		return "list-item";
	}

	@Transactional
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") String id, Model model) {
		itemService.deleteItem(id);
		return listCustomer(model);
	}

	@Transactional
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		List<Item> items = itemService.getItems();
		model.addAttribute("items", items);
		return "list-item";
	}
	
	private static String getItemId() {
		return "item" + System.currentTimeMillis();
	}
}
