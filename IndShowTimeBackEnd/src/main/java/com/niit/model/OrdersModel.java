package com.niit.model;

import java.io.Serializable;
import javax.persistence.*;

//Entity class for Orders Table
@Entity
@Table(name="OrderDetails")
public class OrdersModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private UserModel orderUserDetails;
	
	
	private String orderPayment;
	
	private double orderTotal;
	
	public OrdersModel()
	{
		
	}
	public OrdersModel(int orderId,UserModel orderUserDetails,String orderPayment,double orderTotal)
	{
		this.orderId=orderId;
		this.orderUserDetails=orderUserDetails;
		this.orderPayment=orderPayment;
		this.orderTotal=orderTotal;
		
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserModel getOrderUserDetails() {
		return orderUserDetails;
	}
	public void setOrderUserDetails(UserModel orderUserDetails) {
		this.orderUserDetails = orderUserDetails;
	}
	public String getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
}