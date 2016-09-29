package com.mediAssist.model;

import java.io.Serializable;

public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5985813726988352883L;
	private Double shopId;
	private String shopName;
	private String address;
	
	public Shop(){
		
	}

	public Double getShopId() {
		return shopId;
	}

	public void setShopId(Double shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
