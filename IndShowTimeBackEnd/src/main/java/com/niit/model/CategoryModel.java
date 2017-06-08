package com.niit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//Entity class for Category Table
@Entity
@Table(name="CategoryDetails")
public class CategoryModel implements Serializable
{
	@Id
	private int categoryId;
	
	private String categoryName;
	@OneToMany(mappedBy = "prodCategory",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<ProductModel> categoryProducts=new HashSet<ProductModel>(
			0);

	public CategoryModel()
	{
		super();
	}
	
    public CategoryModel(int categoryId, String categoryName, Set<ProductModel> categoryProducts) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryProducts = categoryProducts;
	}
	//Getter and Setter methods for Product Quantity

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<ProductModel> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(Set<ProductModel> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}
    
    
    //Getter and Setter methods for Product Category
    
    
    //Getter and Setter methods for Product Supplier
  
}
