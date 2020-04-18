package com.rapidcart.exception;

public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 61788799171882056L;

	public ItemNotFoundException(String message) {
		super(message);
	}

}
