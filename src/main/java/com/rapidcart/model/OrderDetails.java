package com.rapidcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@Column(name = "ORDER_DETAILS_ID")
	private String orderDetailsId; // Primary Key

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private Order order; // Foreign Key

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID")
	private Item item; // Foreign Key

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "PRICE")
	private int price;

	// Getters and Setters

	public String getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(String orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
