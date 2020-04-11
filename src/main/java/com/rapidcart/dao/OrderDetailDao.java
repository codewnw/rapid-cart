package com.rapidcart.dao;

import java.util.Set;

import com.rapidcart.model.OrderDetail;

public interface OrderDetailDao {

	OrderDetail getOrderDetail(String orderDetailId);

	Set<OrderDetail> getOrderDetailsByOrderId(String orderId);

	Long createOrderDetail(OrderDetail orderDetail);

	void createOrUpdateOrderDetail(OrderDetail orderDetailId);

	void deleteOrderDetail(String orderDetailId);

}
