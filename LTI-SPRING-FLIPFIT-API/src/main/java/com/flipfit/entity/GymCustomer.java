package com.flipfit.entity;

import org.springframework.stereotype.Component;

@Component
public class GymCustomer extends GymUser{

	private Long gymCustomerId;
	private String cardDetails;
	
	public Long getGymCustomerId() {
		return gymCustomerId;
	}
	public void setGymCustomerId(Long gymCustomerId) {
		this.gymCustomerId = gymCustomerId;
	}
	public String getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}
	
	
}
