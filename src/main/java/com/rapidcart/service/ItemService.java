package com.rapidcart.service;

import java.util.List;

import com.rapidcart.model.Item;

public interface ItemService {
	Long createItem(Item item);

	Item getItem(String id);

	List<Item> getItems();

	void createOrUpdateItem(Item item);

	void deleteItem(String id);

}
