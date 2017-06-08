package com.niit.dao;

import com.niit.model.UserModel;


public interface UserDAO
{
	
	UserModel getUserDetail(String id);
	
	void addUser(UserModel obj);
	
}