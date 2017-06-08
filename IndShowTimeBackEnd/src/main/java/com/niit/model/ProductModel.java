package com.niit.model;

import javax.persistence.*;
import java.io.Serializable;

//Entity class for Product Table
@Entity
@Table(name="ProductDetail")
public class ProductModel implements Serializable
{
	@Id
	@Column(name="prodId")
	private int prodId;

	@Column(name="prodName")
	private String prodName;
	
	@Column(name="prodDesc")
	private String prodDesc;
	
	@Column(name="prodStock")
	private int prodStock;
	
	@Column(name="prodPrice")
	private Double prodPrice;
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
	private CategoryModel prodCategory;
	@ManyToOne
    @JoinColumn(name = "supplierId")
	private SupplierModel prodSupplier;
	
	@Column(name="pImage")
	private String pImage;
	
	

	public ProductModel()
	{
		
	}
	
	public ProductModel(int prodId,String prodName,String prodDesc,int prodStock,
			Double prodPrice,CategoryModel prodCategory,SupplierModel prodSupplier,String pImage)
	{
		this.prodId=prodId;
		
		this.prodName=prodName;
		this.prodDesc=prodDesc;
		this.prodStock=prodStock;
		this.prodPrice=prodPrice;
		this.prodCategory=prodCategory;
		this.prodSupplier=prodSupplier;
		this.pImage=pImage;
	}
	//Getter and Setter methods for Product ID
	public void setProdId(int prodId)
	{
		this.prodId=prodId;
	}
	
    public int getProdId()
    {
    	return prodId;
    }
    
    
    
    //Getter and Setter methods for Product Name
    public void setProdName(String prodName)
	{
		this.prodName=prodName;
	}
    
    public String getProdName()
    {
    	return prodName;
    }
    
   
    //Getter and Setter methods for Product Price
    public void setProdPrice(Double prodPrice)
	{
		this.prodPrice=prodPrice;
	}
    public Double getProdPrice()
    {
    	return prodPrice;
    }
  
    
    //Getter and Setter methods for Product Category
    public void setProdCategory(CategoryModel prodCategory)
	{
		this.prodCategory=prodCategory;
	}
    public CategoryModel getProdCategory()
    {
    	return prodCategory;
    }
    
    //Getter and Setter methods for Product Supplier
    public void setProdSupplier(SupplierModel prodSupplier)
	{
		this.prodSupplier=prodSupplier;
	}
    public SupplierModel getProdSupplier()
    {
    	return prodSupplier;
    }
    public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
    public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public int getProdStock() {
		return prodStock;
	}
	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}
	
 
}