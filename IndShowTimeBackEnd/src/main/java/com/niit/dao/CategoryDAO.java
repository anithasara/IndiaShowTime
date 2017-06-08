package com.niit.dao;
import java.util.List;

import com.niit.model.CategoryModel;

// Category DAO interface
public interface CategoryDAO
{
	//Method for reading all category details
	List<CategoryModel> getAllCategoryDetails();
	//Method for reading single category details
	CategoryModel getCategoryDetail(int id);
	//Method for adding a category details
	void addCategory(CategoryModel obj);
}