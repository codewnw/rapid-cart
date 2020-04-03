package com.rapidcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private String orderId; // Primary Key

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer; // Foreign Key

	@Column(name = "ORDER_TOTAL")
	private int orderTotalPrice;

	public Order(String orderId, Customer customer, int orderTotalPrice) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderTotalPrice=" + orderTotalPrice + "]";
	}

}
