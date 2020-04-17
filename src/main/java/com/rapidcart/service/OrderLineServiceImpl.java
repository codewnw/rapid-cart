package com.rapidcart.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.OrderLineDao;
import com.rapidcart.model.OrderLine;

@Service
public class OrderLineServiceImpl implements OrderLineService {

	@Autowired
	OrderLineDao orderLineDao;

	@Override
	public Long createOrderLine(OrderLine orderLine) {
		return orderLineDao.createOrderLine(orderLine);
	}

	@Override
	public OrderLine getOrderLine(String orderLineId) {
		return orderLineDao.getOrderLine(orderLineId);
	}

	@Override
	public Set<OrderLine> getOrderLinesByOrderId(String orderId) {
		return orderLineDao.getOrderLinesByOrderId(orderId);
	}

	@Override
	public void createOrUpdateOrderLine(OrderLine orderLine) {
		orderLineDao.createOrUpdateOrderLine(orderLine);
	}

	@Override
	public void deleteOrderLine(String orderLineId) {
		orderLineDao.deleteOrderLine(orderLineId);
	}

}
