package com.shopping.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserDetails {
	
	@Id
	private int uProfileId;
	private String uFullName;
	private String uImage;
	private String uEmailId;
	private String uMobileNumber;
	private String uAbout;
	private LocalDate dateOfBirth;
	private String uGender;
	private String uRole;
	private String uPassword;
	
	public UserDetails() {
		
	}

	public UserDetails(int uProfileId, String uFullName, String uImage, String uEmailId, String uMobileNumber,
			String uAbout, LocalDate dateOfBirth, String uGender, String uRole, String uPassword) {
		super();
		this.uProfileId = uProfileId;
		this.uFullName = uFullName;
		this.uImage = uImage;
		this.uEmailId = uEmailId;
		this.uMobileNumber = uMobileNumber;
		this.uAbout = uAbout;
		this.dateOfBirth = dateOfBirth;
		this.uGender = uGender;
		this.uRole = uRole;
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "UserDetails [uProfileId=" + uProfileId + ", uFullName=" + uFullName + ", uImage=" + uImage
				+ ", uEmailId=" + uEmailId + ", uMobileNumber=" + uMobileNumber + ", uAbout=" + uAbout
				+ ", dateOfBirth=" + dateOfBirth + ", uGender=" + uGender + ", uRole=" + uRole + ", uPassword="
				+ uPassword + "]";
	}

	public int getuProfileId() {
		return uProfileId;
	}

	public void setuProfileId(int uProfileId) {
		this.uProfileId = uProfileId;
	}

	public String getuFullName() {
		return uFullName;
	}

	public void setuFullName(String uFullName) {
		this.uFullName = uFullName;
	}

	public String getuImage() {
		return uImage;
	}

	public void setuImage(String uImage) {
		this.uImage = uImage;
	}

	public String getuEmailId() {
		return uEmailId;
	}

	public void setuEmailId(String uEmailId) {
		this.uEmailId = uEmailId;
	}

	public String getuMobileNumber() {
		return uMobileNumber;
	}

	public void setuMobileNumber(String uMobileNumber) {
		this.uMobileNumber = uMobileNumber;
	}

	public String getuAbout() {
		return uAbout;
	}

	public void setuAbout(String uAbout) {
		this.uAbout = uAbout;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getuGender() {
		return uGender;
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

	public String getuRole() {
		return uRole;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	
	
}

	
	
	
	
	
	
	