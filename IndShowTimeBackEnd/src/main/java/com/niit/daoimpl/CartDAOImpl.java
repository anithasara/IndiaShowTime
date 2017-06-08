package com.niit.daoimpl;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.*;
import com.niit.model.*;


public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	OrdersDAO orderDao;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	    public List<CartModel> getCartById (String userId) {     
	    	Session session=sessionFactory.openSession();
	    	List<CartModel> c=null;
	    	c=session.createQuery("from CartModel where userMailId=:mailid").setString("mailid",userId).list();   
	       return c;
	    }

	    public void addCart(CartModel cart) {
	        
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.saveOrUpdate(cart);
	        session.getTransaction().commit();
	    }

	    public CartModel getCartItem(int pid,String  userId)
	    {
	    	 Session session = sessionFactory.openSession();
	    	CartModel c=null;
	    	c=(CartModel)session.createQuery("from CartModel where userMailId=:mailid and cartproductid=:id")
	    			.setString("mailid",userId).setInteger("id", pid).uniqueResult();
	    	return c;
	    }
	   public void updateCart(CartModel cart)
	    {
	    	Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.update(cart);
	        session.getTransaction().commit();
	    }

	public void delete(int cartId) {
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartModel deletec=(CartModel)session.get(CartModel.class, cartId);
        session.delete(deletec);
        session.getTransaction().commit();
	}
}