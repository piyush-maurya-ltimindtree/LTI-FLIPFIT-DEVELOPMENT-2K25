package com.lti.flipfit.beans;

import java.util.List;

public class GymOwner extends GymUser{
	
	private Long gymOwnerId;
	private String pan;
	private Boolean isApproved;
	private List<GymCenter> centersOwned;
	private String cardDetails;
	
	public Long getGymOwnerId() {
		return gymOwnerId;
	}
	public void setGymOwnerId(Long gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public List<GymCenter> getCentersOwned() {
		return centersOwned;
	}
	public void setCentersOwned(List<GymCenter> centersOwned) {
		this.centersOwned = centersOwned;
	}
	public String getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}
	

}
