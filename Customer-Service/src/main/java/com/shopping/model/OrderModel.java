package com.shopping.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class OrderModel {
	
	@Id
	private int orderID;
	private LocalDate orderDate;
	private int userID;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public OrderModel(int orderID, LocalDate orderDate, int userID, double amountPaid, String modeOfPayment,
			String orderStatus, int quantity) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.userID = userID;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}
	
	

}
