package com.niit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//Entity class for Supplier Table
@Entity
@Table(name="SupplierDetails")
public class SupplierModel implements Serializable
{
  @Id
  @Column(name="supplierId")
  private int supplierId;
  @Column(name="supplierName")
  private String supplierName;
  @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "prodSupplier")
  private Set<ProductModel> supplierproducts=new HashSet<ProductModel>(
			0);
  
  public SupplierModel()
  {
	  super();
  }
  public SupplierModel(int supplierId,String supplierName)
  {
	  this.supplierId=supplierId;
	  this.supplierName=supplierName;
  }
  public SupplierModel(int supplierId,String supplierName,Set<ProductModel> supplierproducts)
  {
	  this.supplierId=supplierId;
	  this.supplierName=supplierName;
	  this.supplierproducts=supplierproducts;
  }
//Getter and Setter methods for Product Quantity
  public void setSupplierId(int supplierId)
	{
		this.supplierId=supplierId;
	}
  
  public int getSupplierId()
  {
  	return supplierId;
  }
  
  //Getter and Setter methods for Product Category
  public void setSupplierName(String supplierName)
	{
		this.supplierName=supplierName;
	}
  public String getSupplierName()
  {
  	return supplierName;
  }
  
  //Getter and Setter methods for Product Supplier
 
  public void setSupplierProducts(Set<ProductModel> supplierproducts)
	{
		this.supplierproducts=supplierproducts;
	}
  
  
  public Set<ProductModel> getSupplierProducts()
  {
  	return supplierproducts;
  }
}