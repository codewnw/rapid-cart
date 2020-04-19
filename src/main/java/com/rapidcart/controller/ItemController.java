package com.rapidcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rapidcart.constant.ViewConstant;
import com.rapidcart.exception.ItemNotFoundException;
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

	@Transactional
	@GetMapping("/{id}")
	public String item(@PathVariable("id") String id, Model model) {
		Item item = itemService.getItem(id);
		if (item == null) {
			throw new ItemNotFoundException(String.format("Item %s not found.", id));
		}
		model.addAttribute("item", item);
		return "single-product-details";
	}

	private static String getItemId() {
		return "item" + System.currentTimeMillis();
	}

	@ExceptionHandler(value = ItemNotFoundException.class)
	public ModelAndView handleItemNotFoundException(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(ViewConstant.GLOBAL_ERROR_VIEW);
		return mav;
	}
}
