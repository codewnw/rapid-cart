package com.rapidcart.service;

import com.rapidcart.model.Cart;

public interface CartService {
	Cart getCart(String customerId);
}
