package com.shopping.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
	
	@Id
	private int pId;
	private String pName;
	private String pType;
	private String pCategory;
	private double pPrice;
	private String pDescription;
	
	//Default constructor
	public Product() {
		
	}
	
	//to string
	
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pType=" + pType + ", pCategory=" + pCategory
				+ ", pPrice=" + pPrice + ", pDescription=" + pDescription + "]";
	}
	//Parameterized constructor
	public Product(int pId, String pName, String pType, String pCategory, double pPrice, String pDescription) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pType = pType;
		this.pCategory = pCategory;
		this.pPrice = pPrice;
		this.pDescription = pDescription;
	}



	//Getter and setter
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
	

}
