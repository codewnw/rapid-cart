package com.rapidcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.CustomerDao;
import com.rapidcart.dao.ItemDao;
import com.rapidcart.model.Customer;
import com.rapidcart.model.Item;


@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;

	
	public Long createItem(Item item) {
		return itemDao.createItem(item);
	}

	
	public Item getItem(String id) {
		return itemDao.getItem(id);
	}


	public List<Item> getItems() {
		return itemDao.getItems();
	}


	public void createOrUpdateItem(Item item) {
		itemDao.createOrUpdateItem(item);
	}


	public void deleteItem(String id) {
		itemDao.deleteItem(id);
	}
}
