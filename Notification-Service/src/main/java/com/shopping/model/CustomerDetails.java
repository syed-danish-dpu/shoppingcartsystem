package com.shopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class CustomerDetails {
	@Id
	private int CustId;
	private String CustName;
	private String CustEmail;
	private String CustPhone;
	private String CustAddress;
	private String CustPassword;
	
	//Default Constructor
	public CustomerDetails() {
		
	}

	public CustomerDetails(int custId, String custName, String custEmail, String custPhone, String custAddress,
			String custPassword) {
		super();
		CustId = custId;
		CustName = custName;
		CustEmail = custEmail;
		CustPhone = custPhone;
		CustAddress = custAddress;
		CustPassword = custPassword;
	}

	@Override
	public String toString() {
		return "CustomerDetails [CustId=" + CustId + ", CustName=" + CustName + ", CustEmail=" + CustEmail
				+ ", CustPhone=" + CustPhone + ", CustAddress=" + CustAddress + ", CustPassword=" + CustPassword + "]";
	}

	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getCustEmail() {
		return CustEmail;
	}

	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

	public String getCustPhone() {
		return CustPhone;
	}

	public void setCustPhone(String custPhone) {
		CustPhone = custPhone;
	}

	public String getCustAddress() {
		return CustAddress;
	}

	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}

	public String getCustPassword() {
		return CustPassword;
	}

	public void setCustPassword(String custPassword) {
		CustPassword = custPassword;
	}
	
	
	




	

}
