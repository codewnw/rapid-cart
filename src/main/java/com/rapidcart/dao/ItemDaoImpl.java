package com.rapidcart.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Long createItem(Item item) {
		return (Long) sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public Item getItem(String id) {
		return sessionFactory.getCurrentSession().get(Item.class, id);
	}

	@Override
	public List<Item> getItems() {
		return sessionFactory.getCurrentSession().createQuery("from Item order by id").getResultList();
	}

	@Override
	public void createOrUpdateItem(Item item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
		
	}

	@Override
	public void deleteItem(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Item WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	
}
