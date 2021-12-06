package model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "orders")
public class Order {
	
	@Id
	private int orderId;
	private String carName;
	private String carModel;
	private String wName;
	private int washPackId;
	private String date;
	private long phoneNo;
	
	
	//No parameter Constructor or default constructor
	
	public Order() {
		
	}
	//to string 
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", wName=" + wName
				+ ", washPackId=" + washPackId + ", date=" + date + ", phoneNo=" + phoneNo + "]";
	}
	//parameterised constructor
	public Order(int orderId, String carName, String carModel, String wName, int washPackId, String date, long phoneNo) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.carModel = carModel;
		this.wName = wName;
		this.washPackId = washPackId;
		this.date = date;
		this.phoneNo = phoneNo;
	}
	//getters and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public int getWashPackId() {
		return washPackId;
	}
	public void setWashPackId(int washPackId) {
		this.washPackId = washPackId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

	
	
	
	
	
	
	
	
}