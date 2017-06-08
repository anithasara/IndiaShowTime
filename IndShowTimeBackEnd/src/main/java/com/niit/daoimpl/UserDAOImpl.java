package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.UserDAO;
import com.niit.model.UserModel;


public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserModel getUserDetail(String id) {
		UserModel user = (UserModel) sessionFactory.openSession().get(UserModel.class, id);

		return user;
	}

	public void addUser(UserModel obj) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}