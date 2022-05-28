package com.example.demo.entities;

public class CartDTO {
	private String customerId;
	private String mobileId;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String customerId, String mobileId) {
		super();
		this.customerId = customerId;
		this.mobileId = mobileId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
}
