package com.rapidcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Customer;
import com.rapidcart.model.Item;



@Repository
public class ItemDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Long createItem(Item item) {
		return (Long) sessionFactory.getCurrentSession().save(item);
	}
	
	
	public void createOrUpdateItem(Item item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
	}
	
	public Item getItem(String id) {
		return sessionFactory.getCurrentSession().get(Item.class, id);
	}

	
	public List<Item> getItems() {
		return sessionFactory.getCurrentSession().createQuery("from Item order by id").getResultList();
	}


	public void deleteItem(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Item WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
