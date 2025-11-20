package com.lti.flipfit.beans;

public class GymCenter {
	
	private Long gymCenterId;
	private Long gymOwnerId;
	private String gymCenterName;
	private String gstNumber;
	private GymAddress address;
	private Integer capacity;
	private Boolean isApproved;
	private Double amountPerSlot;
	
	public Long getGymCenterId() {
		return gymCenterId;
	}
	public void setGymCenterId(Long gymCenterId) {
		this.gymCenterId = gymCenterId;
	}
	public Long getGymOwnerId() {
		return gymOwnerId;
	}
	public void setGymOwnerId(Long gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}
	public String getGymCenterName() {
		return gymCenterName;
	}
	public void setGymCenterName(String gymCenterName) {
		this.gymCenterName = gymCenterName;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public GymAddress getAddress() {
		return address;
	}
	public void setAddress(GymAddress address) {
		this.address = address;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Double getAmountPerSlot() {
		return amountPerSlot;
	}
	public void setAmountPerSlot(Double amountPerSlot) {
		this.amountPerSlot = amountPerSlot;
	}
	

}
