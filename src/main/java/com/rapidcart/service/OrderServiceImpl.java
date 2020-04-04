package com.rapidcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.dao.OrderDao;
import com.rapidcart.model.Order;

@Repository
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public Order getOrder(String id) {
		return orderDao.getOrder(id);
	}

	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public Long createOrder(Order order) {
		return orderDao.createOrder(order);
	}

	@Override
	public void createOrUpdateOrder(Order order) {
		orderDao.createOrUpdateOrder(order);
	}

	@Override
	public void deleteOrder(String id) {
		orderDao.deleteOrder(id);
	}

}
