package com.niit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//Entity class for User Table
@Entity
@Table(name="UserDetails")
public class UserModel 
{
	@Id
	@Email(message="Enter valid MailIdd")
	@NotEmpty(message="Mailid should not be empty")
	
	@Column(name="userMailId")
	private String userMailId;
	
	@NotEmpty(message="Please enter the name")
	@Column(name="userName")
	private String userName;
	
	@NotEmpty(message="Please enter the password")
	@Column(name="userPassword")
	private String userPassword;
	
	@Pattern(regexp="[\\d]{10}",message="Phone number cannot be alphabetics")
	@NotEmpty(message="Please enter the phone number")
	@Size(min=0,max=14,message="Enter correct Phone number")
	@Column(name="userPhoneNo")
	private String userPhoneNo;
	
	@NotEmpty(message="Please enter the address")
	@Column(name="userAddress")
	private String userAddress;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderUserDetails")
	private Set<OrdersModel> userOrders = new HashSet<OrdersModel>(0);
	@Column(name="userRole")
	private String userRole;
	@Column(name="userenabled")
	private boolean userenabled;
	
	public boolean isUserenabled() {
		return userenabled;
	}

	public void setUserenabled(boolean userenabled) {
		this.userenabled = userenabled;
	}

	public UserModel()
	{
		
	}
	
	public UserModel(String userMailId,String userName,String userPassword,
			String userPhoneNo,Set<OrdersModel> userOrders,String userAddress,String userRole)
	{
		this.userMailId=userMailId;
		this.userName=userName;
		this.userPassword=userPassword;
		this.userPhoneNo=userPhoneNo;
		this.userOrders=userOrders;
		this.userAddress=userAddress;
		this.userRole=userRole;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public Set<OrdersModel> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(Set<OrdersModel> userOrders) {
		this.userOrders = userOrders;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}  
	    
}