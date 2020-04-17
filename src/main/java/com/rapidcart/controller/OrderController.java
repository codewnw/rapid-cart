package com.rapidcart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapidcart.model.Order;
import com.rapidcart.service.OrderService;
import com.rapidcart.swagger.SwaggerApiResponses;

@SwaggerApiResponses
@Controller
@RequestMapping("/orders")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping("/add")
	public String createOrder(Model model) {
		logger.info("Inside Order Controller");
		logger.debug("Inside Order Controller");
		Order order = new Order();
		model.addAttribute("order", order);
		return "add-order";
	}

	@Transactional
	@RequestMapping("/update")
	public String updateOrder(@RequestParam("id") String id, Model model) {
		Order order = orderService.getOrder(id);
		model.addAttribute("order", order);
		return "add-order";
	}

	@Transactional
	@RequestMapping("/save")
	public String saveCustomer(@ModelAttribute("order") Order order, Model model) {
		if (order.getOrderId() == null || order.getOrderId().equals("")) {
			order.setOrderId(getOrderId());
		}
		orderService.createOrUpdateOrder(order);
		List<Order> orders = orderService.getOrders();
		model.addAttribute("orders", orders);
		return "list-orders";
	}

	@Transactional
	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id") String id, Model model) {
		orderService.deleteOrder(id);
		return listOrder(model);
	}

	@Transactional
	@RequestMapping("/list")
	public String listOrder(Model model) {
		List<Order> orders = orderService.getOrders();
		model.addAttribute("orders", orders);
		return "list-orders";
	}

	private static String getOrderId() {
		return "ORD" + System.currentTimeMillis();
	}

}
