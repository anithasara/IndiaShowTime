package com.niit.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.niit.model.ProductModel;


public interface ProductDAO
{
	List<ProductModel> getAllProductDetails();
    ProductModel getProductDetail(int id);
	void updateProductDetails(ProductModel obj);
	void addProduct(ProductModel obj);
	void delete(ProductModel entity);
	List<ProductModel> getProductsByCategory(int cid);
}