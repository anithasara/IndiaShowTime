package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.SupplierDAO;
import com.niit.model.SupplierModel;

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<SupplierModel> getAllSupplierDetails() {
		Session session = sessionFactory.openSession();
		List<SupplierModel> suppliers = null;
		session.beginTransaction();
		suppliers = session.createQuery("from SupplierModel").list();
		session.getTransaction().commit();
		return suppliers;
	}

	public SupplierModel getSupplierDetail(int id) {
		SupplierModel supplier = (SupplierModel) sessionFactory.openSession().get(SupplierModel.class, id);

		return supplier;
	}

	/*
	 * public void updateSupplierDetails(SupplierModel obj) {
	 * getCurrentSession().update(obj);
	 * 
	 * }
	 */

	public void addSupplier(SupplierModel obj) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
	}
	/*
	 * public void delete(SupplierModel entity) {
	 * getCurrentSession().delete(entity);
	 * 
	 * }
	 */

}