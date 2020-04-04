package com.rapidcart.dao;

import java.util.List;

import com.rapidcart.model.Item;



public interface ItemDao {
	Long createItem(Item item);

	Item getItem(String id);

	List<Item> getItems();

	void createOrUpdateItem(Item item);

	void deleteItem(String id);
}
