package com.rapidcart.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Order;
import com.rapidcart.model.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public OrderDetail getOrderDetail(String orderDetailId) {
		return sessionFactory.getCurrentSession().get(OrderDetail.class, orderDetailId);
	}

	@Override
	public Long createOrderDetail(OrderDetail orderDetail) {
		return (Long) sessionFactory.getCurrentSession().save(orderDetail);
	}

	@Override
	public void createOrUpdateOrderDetail(OrderDetail orderDetail) {
		sessionFactory.getCurrentSession().save(orderDetail);
	}

	@Override
	public void deleteOrderDetail(String orderDetailId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("DELETE FROM OrderDetail WHERE orderDetailId =: orderDetailId");
		query.setParameter("orderDetailId", orderDetailId);
		query.executeUpdate();
	}

	@Override
	public Set<OrderDetail> getOrderDetailsByOrderId(String orderId) {

		return new HashSet<OrderDetail>(sessionFactory.getCurrentSession()
				.createQuery("FROM orderDetails ORDER BY orderDetailsId").getResultList());
	}

}
