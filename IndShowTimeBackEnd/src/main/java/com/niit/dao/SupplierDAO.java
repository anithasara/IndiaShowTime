package com.niit.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.niit.model.SupplierModel;


public interface SupplierDAO
{
	List<SupplierModel> getAllSupplierDetails();
	void addSupplier(SupplierModel obj);
	SupplierModel getSupplierDetail(int id);
}