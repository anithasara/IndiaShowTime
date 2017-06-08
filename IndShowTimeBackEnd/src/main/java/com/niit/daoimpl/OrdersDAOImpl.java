package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.CartDAO;
import com.niit.dao.OrdersDAO;
import com.niit.model.OrdersModel;

public class OrdersDAOImpl implements OrdersDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CartDAO cartDao;
	
	public OrdersDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	public void addOrder(OrdersModel order) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(order);
        session.getTransaction().commit();
		
	}

}