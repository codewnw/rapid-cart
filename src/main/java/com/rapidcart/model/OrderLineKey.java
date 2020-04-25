package com.rapidcart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLineKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;

	private String itemId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	//TODO Hashcode and Equals

}
