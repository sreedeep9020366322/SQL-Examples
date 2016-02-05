package com.training.entity;


public class Customer {

	private int customerId;
	private String customerName;
	private String emailId;
	private long handPhone;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Declare Rule
	public Customer(int customerId, String customerName, String emailId, long handPhone) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.handPhone = handPhone;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getHandPhone() {
		return handPhone;
	}
	
	//Handle Rule
	public void setHandPhone(long handPhone) {
		
		this.handPhone = handPhone;
	}
	
	public String showCustomer(){
		String cust = customerId + ":" + customerName + ":" + emailId +  ":" + handPhone;
		return cust;
	}
	
}
