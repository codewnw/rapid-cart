package com.rapidcart.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.OrderDetailDao;
import com.rapidcart.model.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailDao orderDetailDao;

	@Override
	public Long createOrderDetail(OrderDetail orderDetail) {
		return orderDetailDao.createOrderDetail(orderDetail);
	}

	@Override
	public OrderDetail getOrderDetail(String orderDetailId) {
		return orderDetailDao.getOrderDetail(orderDetailId);
	}

	@Override
	public Set<OrderDetail> getOrderDetailsByOrderId(String orderId) {
		return orderDetailDao.getOrderDetailsByOrderId(orderId);
	}

	@Override
	public void createOrUpdateOrderDetail(OrderDetail orderDetail) {
		orderDetailDao.createOrUpdateOrderDetail(orderDetail);
	}

	@Override
	public void deleteOrderDetail(String orderDetailId) {
		orderDetailDao.deleteOrderDetail(orderDetailId);
	}

}
