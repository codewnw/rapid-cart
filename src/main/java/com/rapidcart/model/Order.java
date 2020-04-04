package com.rapidcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private String orderId; // Primary Key

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer; // Foreign Key

	@Column(name = "ORDER_TOTAL")
	private int orderTotal;

	@Column(name = "ORDER_DATE")
	private int orderDate;

	@Column(name = "ZIPCODE")
	private int zipcode;

	public Order(String orderId, Customer customer, int orderTotal, int orderDate, int zipcode) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
		this.zipcode = zipcode;
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

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
