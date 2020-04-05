package com.rapidcart.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private Date orderDate;

	@Column(name = "ZIPCODE")
	private int zipcode;

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

	public String getOrderDate() {
		if (orderDate != null) {
			return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(orderDate);
		}
		return "YYYY-MM-DD";
	}

	public void setOrderDate(String orderDate) throws ParseException {
		this.orderDate = new SimpleDateFormat("yyyy-mm-dd").parse(orderDate);
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
