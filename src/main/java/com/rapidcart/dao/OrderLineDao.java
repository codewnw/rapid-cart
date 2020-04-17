package com.rapidcart.dao;

import java.util.Set;

import com.rapidcart.model.OrderLine;

public interface OrderLineDao {

	OrderLine getOrderLine(String OrderLineId);

	Set<OrderLine> getOrderLinesByOrderId(String orderId);

	Long createOrderLine(OrderLine orderLine);

	void createOrUpdateOrderLine(OrderLine orderLineId);

	void deleteOrderLine(String orderLineId);

}
