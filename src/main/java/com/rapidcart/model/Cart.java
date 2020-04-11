package com.rapidcart.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Loader;
import org.hibernate.engine.FetchStyle;

@Entity
@Table(name = "CART")
public class Cart {

	@Override
	public String toString() {
		return "Cart [id=" + id + ", items=" + items + "]";
	}

	@Id
	@Column(name = "ID")
	private String id;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CART_ITEMS", joinColumns = @JoinColumn(name = "CART_ID"))
	@Column(name = "items")
	private Set<String> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getItems() {
		return items;
	}

	public void setItems(Set<String> items) {
		this.items = items;
	}

	public Cart(String id, Set<String> items) {
		super();
		this.id = id;
		this.items = items;
	}

	public Cart() {
		super();
	}

}
