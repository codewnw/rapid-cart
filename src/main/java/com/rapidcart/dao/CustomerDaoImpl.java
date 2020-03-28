package com.rapidcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapidcart.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Long createCustomer(Customer customer) {
		return (Long) sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void createOrUpdateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(String id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public List<Customer> getCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer order by id").getResultList();
	}

	@Override
	public void deleteCustomer(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Customer WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
