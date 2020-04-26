package com.rapidcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapidcart.dao.ItemDao;
import com.rapidcart.model.Item;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public Long createItem(Item item) {
		return itemDao.createItem(item);
	}

	@Override
	public Item getItem(String id) {
		return itemDao.getItem(id);
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public void createOrUpdateItem(Item item) {
		itemDao.createOrUpdateItem(item);
	}

	@Override
	public void deleteItem(String id) {
		itemDao.deleteItem(id);
	}

	@Override
	public List<Item> getItemsByIds(List<String> ids) {
		return itemDao.getItemsByIds(ids);
	}

}
