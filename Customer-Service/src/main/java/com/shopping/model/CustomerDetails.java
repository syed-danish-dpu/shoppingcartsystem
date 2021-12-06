package com.shopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class CustomerDetails {
	@Id
	private int custId;
	private String custName;
	private String custEmail;
	private String custPhone;
	private String custAddress;
	private String custPassword;

	// Default Constructor
	public CustomerDetails() {

	}

	

	public CustomerDetails(int custId, String custName, String custEmail, String custPhone, String custAddress,
			String custPassword) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPhone = custPhone;
		this.custAddress = custAddress;
		this.custPassword = custPassword;
	}



	public int getCustId() {
		return custId;
	}



	public void setCustId(int custId) {
		this.custId = custId;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getCustEmail() {
		return custEmail;
	}



	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}



	public String getCustPhone() {
		return custPhone;
	}



	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}



	public String getCustAddress() {
		return custAddress;
	}



	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}



	public String getCustPassword() {
		return custPassword;
	}



	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}


	
}
