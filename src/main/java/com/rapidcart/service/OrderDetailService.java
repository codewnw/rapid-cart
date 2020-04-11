package com.rapidcart.service;

import java.util.Set;
import com.rapidcart.model.OrderDetail;

public interface OrderDetailService {

	Long createOrderDetail(OrderDetail orderDetail);

	OrderDetail getOrderDetail(String orderDetailId);

	Set<OrderDetail> getOrderDetailsByOrderId(String orderId);

	void createOrUpdateOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetail(String orderDetailId);

}
