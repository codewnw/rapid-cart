package com.rapidcart.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

	@EmbeddedId
	private OrderLineKey orderLineKey;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "PRICE")
	private int price;

	public OrderLineKey getOrderLineKey() {
		return orderLineKey;
	}

	public void setOrderLineKey(OrderLineKey orderLineKey) {
		this.orderLineKey = orderLineKey;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
