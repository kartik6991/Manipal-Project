package com.example.demo.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CartDTO {
	@Size(min = 3, max = 25, message = "UserId should be min of 3 chars & max of 25 chars.")
	@Pattern(regexp = "[0-9]+", message = "UserId should be Numeric, No space allowed.")
	private String customerId;
	@Size(min = 10, max = 10, message = "Mobile Id should be min of 10 chars & max of 10 chars.")
	@Pattern(regexp = "[0-9]+", message = "Mobile Id should be Numeric, No space allowed.")
	private String mobileId;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(
			@Size(min = 3, max = 25, message = "UserId should be min of 3 chars & max of 25 chars.") @Pattern(regexp = "[0-9]+", message = "UserId should be Numeric, No space allowed.") String customerId,
			@Size(min = 10, max = 10, message = "Mobile Id should be min of 10 chars & max of 10 chars.") @Pattern(regexp = "[0-9]+", message = "Mobile Id should be Numeric, No space allowed.") String mobileId) {
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
