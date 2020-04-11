package com.rapidcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "QNTY")
	private Integer qnty;

	@Column(name = "PRICE")
	private Integer price;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
	private Set<OrderDetail> orderDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQnty() {
		return qnty;
	}

	public void setQnty(Integer qnty) {
		this.qnty = qnty;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ",price=" + price + ",qnty=" + qnty + "]";
	}

}
