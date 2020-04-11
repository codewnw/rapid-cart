package com.rapidcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.CartDao;
import com.rapidcart.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	private final CartDao cartDao;

	@Autowired
	public CartServiceImpl(CartDao cartDao) {
		super();
		this.cartDao = cartDao;
	}

	@Override
	public Cart getCart(String customerId) {
		return cartDao.getCart(customerId);
	}

}
