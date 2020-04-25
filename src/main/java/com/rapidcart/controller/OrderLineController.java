package com.rapidcart.controller;

import java.util.List;
import java.util.Set;

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
import com.rapidcart.model.OrderLine;
import com.rapidcart.service.OrderLineService;
import com.rapidcart.swagger.SwaggerApiResponses;

@SwaggerApiResponses
@Controller
@RequestMapping("/orderLines")
public class OrderLineController {

	private static final Logger logger = LoggerFactory.getLogger(OrderLineController.class);

	@Autowired
	private OrderLineService orderLineService;

	@GetMapping("/add")
	public String createOrderLines(Model model) {
		model.addAttribute("orderLine", new OrderLine());
		return "add-order-detail";
	}

	/*
	 * @Transactional
	 * 
	 * @RequestMapping("/update") public String updateOrderLines(@RequestParam("id")
	 * String orderId, Model model) {
	 * 
	 * logger.debug("Inside updateOrderLines() Method");
	 * 
	 * Set<OrderLine> orderLine = orderLineService.getOrderLinesByOrderId(orderId);
	 * 
	 * model.addAttribute("order", orderLine);
	 * 
	 * return "add-order-detail"; }
	 */

	@Transactional

	@RequestMapping("/save")
	public void saveOrderLines(@ModelAttribute("orderline") OrderLine orderLines, Model model) {
		orderLineService.createOrUpdateOrderLine(orderLines);
		// List<Order> orders = orderLineService.getOrders();
		// model.addAttribute("orders", orders);
		// return "list-order-detail";
	}

	@Transactional
	@RequestMapping("/delete")
	public String deleteOrderLines(@RequestParam("id") String id, Model model) {

		orderLineService.deleteOrderLine(id);
		return listOrderLines(id, model);
	}

	@Transactional
	@RequestMapping("/list")
	public String listOrderLines(@RequestParam("id") String orderId, Model model) {
		Set<OrderLine> orderLines = orderLineService.getOrderLinesByOrderId(orderId);
		model.addAttribute("orders", orderLines);
		return "list-order-details";
	}

}
