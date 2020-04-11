package com.rapidcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public CartDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public String createCustomer(Cart cart) {
		return (String) sessionFactory.getCurrentSession().save(cart);
	}

	@Override
	public Cart getCart(String customerId) {
		return sessionFactory.getCurrentSession().get(Cart.class, customerId);
	}

}
