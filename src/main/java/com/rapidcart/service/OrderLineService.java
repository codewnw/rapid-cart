package com.rapidcart.service;

import java.util.Set;

import com.rapidcart.model.OrderLine;

public interface OrderLineService {

	Long createOrderLine(OrderLine orderLine);

	OrderLine getOrderLine(String orderLineId);

	Set<OrderLine> getOrderLinesByOrderId(String orderId);

	void createOrUpdateOrderLine(OrderLine orderLine);

	void deleteOrderLine(String orderLineId);

}
