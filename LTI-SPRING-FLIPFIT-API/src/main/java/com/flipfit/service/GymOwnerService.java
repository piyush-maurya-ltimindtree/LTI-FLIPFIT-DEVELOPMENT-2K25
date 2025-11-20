package com.flipfit.service;

import com.flipfit.entity.Booking;
import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;

import java.util.List;



public interface GymOwnerService {
	
	public GymCenter addGymCenter();
	public GymCenter updateGymCenterDetails();
	
	
	public List<Booking> viewBookingsForGymCenter();
	
	
	public void configureGymSlots();
	
	public GymCenter getGymCenterByGymOwnerId();
	
	public List<GymSlot> getGymSlotsByGymCenter();
	
	public Boolean requestGymOwnerApproval();
	

}
