package com.mediAssist.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5812915013248281279L;
	
	private Double userId;
	private String userName;
	private String currentAddress;
	private String permanetAddress;
	private List<Document> documents;
	
	private List<Shop> shops;
	
	
	public User(){
		
	}

	
	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public Double getUserId() {
		return userId;
	}

	public void setUserId(Double userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
