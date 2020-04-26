package com.rapidcart.service;

import java.util.List;

import com.rapidcart.model.Item;

public interface ItemService {
	Long createItem(Item item);

	Item getItem(String id);

	List<Item> getItems();

	void createOrUpdateItem(Item item);
	
	List<Item> getItemsByIds(List<String> ids);

	void deleteItem(String id);

}
