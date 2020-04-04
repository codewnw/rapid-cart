package com.rapidcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Long createOrder(Order order) {
		return (Long) sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public void createOrUpdateOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	public Order getOrder(String id) {
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public List<Order> getOrders() {
		return sessionFactory.getCurrentSession().createQuery("from ORDER_TABLE order by id").getResultList();
	}

	@Override
	public void deleteOrder(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("DELETE FROM ORDER_TABLE WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
