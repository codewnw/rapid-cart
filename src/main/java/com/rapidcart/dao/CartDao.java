package com.rapidcart.dao;

import com.rapidcart.model.Cart;

public interface CartDao {
	Cart getCart(String customerId);
}
