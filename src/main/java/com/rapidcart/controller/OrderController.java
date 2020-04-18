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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rapidcart.constant.ViewConstant;
import com.rapidcart.exception.OrderNotFoundException;
import com.rapidcart.model.Order;
import com.rapidcart.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/add")
	public String createOrder(Model model) {
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

	@Transactional
	@RequestMapping("/{id}")
	public @ResponseBody Order getOrder(@PathVariable("id") String id) {
		Order order = orderService.getOrder(id);
		if (order == null) {
			throw new OrderNotFoundException(String.format("Order %d not found", id));
		}
		return order;
	}

	private static String getOrderId() {
		return "ORD" + System.currentTimeMillis();
	}

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ModelAndView handleOrderNotFoundException(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(ViewConstant.GLOBAL_ERROR_VIEW);
		return mav;
	}
}
