package com.niit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

//Entity class for Cart Table
@Entity
@Table(name = "CartDetails")
public class CartModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;

	private int cartProductId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userMailId")
	private UserModel cartUserDetails;
	
	private Double cartPrice;
		
	private int cartQuantity;
	
	private String cartProdName;
	
	private String cartImage;

	public CartModel() {

	}

	public CartModel(int cartId, int cartProductId, UserModel cartUserDetails,
			Double cartPrice, int cartQuantity,String cartProdName,String cartImage) {
		this.cartId = cartId;
		this.cartProductId = cartProductId;
		this.cartUserDetails = cartUserDetails;
		this.cartPrice = cartPrice;
		this.cartQuantity = cartQuantity;
		this.cartImage=cartImage;
		this.cartProdName=cartProdName;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public UserModel getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(UserModel cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String getCartProdName() {
		return cartProdName;
	}

	public void setCartProdName(String cartProdName) {
		this.cartProdName = cartProdName;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}
}