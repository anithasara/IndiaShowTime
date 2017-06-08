package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.CategoryDAO;
import com.niit.model.CategoryModel;

public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<CategoryModel> getAllCategoryDetails() {
		Session session = sessionFactory.openSession();
		List<CategoryModel> products = null;
		session.beginTransaction();
		products = session.createQuery("from CategoryModel").list();
		session.getTransaction().commit();
		return products;
	}

	public CategoryModel getCategoryDetail(int id) {
		CategoryModel category = (CategoryModel) sessionFactory.openSession().get(CategoryModel.class, id);

		return category;
	}
	

	public void addCategory(CategoryModel obj) {
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