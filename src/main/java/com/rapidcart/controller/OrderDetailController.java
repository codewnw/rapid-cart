package com.rapidcart.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rapidcart.model.Item;
import com.rapidcart.model.Order;
import com.rapidcart.model.OrderDetail;
import com.rapidcart.service.OrderDetailService;
import com.rapidcart.swagger.SwaggerApiResponses;

@SwaggerApiResponses
@Controller
@RequestMapping("/order-lines")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping("/add")
	public String createOrderDetails(Model model) {
		model.addAttribute("orderDetail", new OrderDetail());
		model.addAttribute("order", new Order());
		return "add-order-detail";
	}

	@Transactional
	@RequestMapping("/update")
	public String updateOrderDetails(@RequestParam("id") String orderId, Model model) {
		Set<OrderDetail> orderDetail = orderDetailService.getOrderDetailsByOrderId(orderId);
		model.addAttribute("order", orderDetail);
		return "add-order-detail";
	}

	/*
	 * @Transactional
	 * 
	 * @RequestMapping("/save") public String
	 * saveOrderDetails(@ModelAttribute("orderdetails") String OrderDetails, Model
	 * model) { if (order.getOrderId() == null || order.getOrderId().equals("")) {
	 * order.setOrderId(getOrderId()); }
	 * orderDetailService.createOrUpdateOrderDetail(order); List<Order> orders =
	 * orderDetailService.getOrders(); model.addAttribute("orders", orders); return
	 * "list-order-detail"; }
	 */

	@Transactional
	@RequestMapping("/delete")
	public String deleteOrderDetails(@RequestParam("id") String id, Model model) {

		orderDetailService.deleteOrderDetail(id);
		return listOrderDetails(id, model);
	}

	@Transactional
	@RequestMapping("/list")
	public String listOrderDetails(@RequestParam("id") String orderId, Model model) {
		Set<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(orderId);
		model.addAttribute("orders", orderDetails);
		return "list-order-details";
	}

	private static String getOrderDetailsId() {
		return "ORDTLS" + System.currentTimeMillis();
	}

}
