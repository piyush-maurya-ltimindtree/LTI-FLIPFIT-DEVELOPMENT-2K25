package com.flipfit.entity;

import java.util.List;

public class GymAddress {
	
	private String addressLine1;
	private String addressLine2;
	private List<String> district;
	private List<String> state;
	private List<String> country;
	private Long pinCode;
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public List<String> getDistrict() {
		return district;
	}
	public void setDistrict(List<String> district) {
		this.district = district;
	}
	public List<String> getState() {
		return state;
	}
	public void setState(List<String> state) {
		this.state = state;
	}
	public List<String> getCountry() {
		return country;
	}
	public void setCountry(List<String> country) {
		this.country = country;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	
	

}
