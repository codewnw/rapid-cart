package com.rapidcart.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7642671913135519311L;

	public OrderNotFoundException(String message) {
		super(message);
	}

}
