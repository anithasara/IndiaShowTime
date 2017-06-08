package com.niit.dao;


import java.util.List;

import com.niit.model.CartModel;

public interface CartDAO
{
	
	List<CartModel> getCartById (String userId);
    void addCart(CartModel cart);
    public CartModel getCartItem(int pid,String  userId);
    void updateCart(CartModel cart);
    void delete(int cartId);
}