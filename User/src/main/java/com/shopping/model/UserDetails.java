package com.shopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserDetails {
	@Id
	private int uId;
	private String uName;
	private String uEmail;
	private String uPhone;
	private String uAddress;
	private String uPassword;
	
	//Default Constructor
	public UserDetails() {
		
	}
	
	//parametrized constructor
	public UserDetails(int uId, String uName, String uEmail, String uPhone, String uAddress, String uPassword) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.uPassword = uPassword;
	}
	
//to string
	@Override
	public String toString() {
		return "UserDetails [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPhone=" + uPhone
				+ ", uAddress=" + uAddress + ", uPassword=" + uPassword + "]";
	}
   
	//getter and setter
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	
	

}
