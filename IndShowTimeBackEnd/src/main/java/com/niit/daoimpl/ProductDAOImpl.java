package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ProductDAO;
import com.niit.model.ProductModel;


public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	//Getting Product details from Model
	public List<ProductModel> getAllProductDetails()
	{
		Session session=sessionFactory.openSession();
		List<ProductModel> products =null;
		session.beginTransaction();
		products= session.createQuery("from ProductModel").list();   
		session.getTransaction().commit();
		  return products;
		
	}
		
	public void updateProductDetails(ProductModel obj)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
	
	}
	public void addProduct(ProductModel obj)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
	}

	public void delete(ProductModel entity) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}

	public ProductModel getProductDetail(int id) {
		ProductModel product = (ProductModel) sessionFactory.openSession().get(ProductModel.class, id);

        return product;
	}

	public List<ProductModel> getProductsByCategory(int cid) {
		
		Session session=sessionFactory.openSession();
		List<ProductModel> products =null;
		session.beginTransaction();
		products= session.createQuery("from ProductModel where categoryid="+cid).list();   
		session.getTransaction().commit();
		  return products;
	}

	

}