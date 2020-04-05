package com.rapidcart.service;

import java.util.List;

import com.rapidcart.model.Order;

public interface OrderService {

	public Order getOrder(String id);

	List<Order> getOrders();

	Long createOrder(Order order);

	void createOrUpdateOrder(Order order);

	void deleteOrder(String id);

}