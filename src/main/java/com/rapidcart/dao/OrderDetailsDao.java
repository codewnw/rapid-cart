package com.rapidcart.dao;

import java.util.List;

import com.rapidcart.model.OrderDetails;

public interface OrderDetailsDao {

	List<OrderDetails> getOrderDetailsbyOrderId(String orderId);

	Long createOrderDetails(OrderDetails orderDetails);

	void createOrUpdateOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(String orderDetailsId);
}