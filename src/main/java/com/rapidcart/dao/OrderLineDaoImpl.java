package com.rapidcart.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Order;
import com.rapidcart.model.OrderLine;

@Repository
public class OrderLineDaoImpl implements OrderLineDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public OrderLine getOrderLine(String orderDetailId) {
		return sessionFactory.getCurrentSession().get(OrderLine.class, orderDetailId);
	}

	@Override
	public Long createOrderLine(OrderLine orderDetail) {
		return (Long) sessionFactory.getCurrentSession().save(orderDetail);
	}

	@Override
	public void createOrUpdateOrderLine(OrderLine orderDetail) {
		sessionFactory.getCurrentSession().save(orderDetail);
	}

	@Override
	public void deleteOrderLine(String orderDetailId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("DELETE FROM OrderLine WHERE orderDetailId =: orderDetailId");
		query.setParameter("orderDetailId", orderDetailId);
		query.executeUpdate();
	}

	@Override
	public Set<OrderLine> getOrderLinesByOrderId(String orderId) {

		return new HashSet<OrderLine>(sessionFactory.getCurrentSession()
				.createQuery("FROM orderDetails ORDER BY orderDetailsId").getResultList());
	}

}
