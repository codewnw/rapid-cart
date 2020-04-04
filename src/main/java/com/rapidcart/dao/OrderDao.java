package com.rapidcart.dao;

import java.util.List;

import com.rapidcart.model.Order;

public interface OrderDao {

	public Order getOrder(String id);

	List<Order> getOrders();

	Long createOrder(Order order);

	void createOrUpdateOrder(Order order);

	void deleteOrder(String id);

}