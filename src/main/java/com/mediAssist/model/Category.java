package com.mediAssist.model;

import java.util.List;

public class Category {
	private Double categoryId;
	private String categoryName;
	private Double categoryseqNum;
	private List<Scope> scopes;
	
	
	public Double getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Double categoryId) {
		this.categoryId = categoryId;
	}
	public Double getCategoryseqNum() {
		return categoryseqNum;
	}
	public void setCategoryseqNum(Double categoryseqNum) {
		this.categoryseqNum = categoryseqNum;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Scope> getScopes() {
		return scopes;
	}
	public void setScopes(List<Scope> scopes) {
		this.scopes = scopes;
	}
	
	
	
}
