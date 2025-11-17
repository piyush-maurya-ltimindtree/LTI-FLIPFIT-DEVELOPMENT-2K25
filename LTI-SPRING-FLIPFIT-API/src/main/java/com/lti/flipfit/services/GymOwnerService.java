package com.lti.flipfit.services;

import java.util.List;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymSlot;

public interface GymOwnerService {
	
	public GymCenter addGymCenter();
	public GymCenter updateGymCenterDetails();
	
	
	public List<Booking> viewBookingsForGymCenter();
	
	
	public void configureGymSlots();
	
	public GymCenter getGymCenterByGymOwnerId();
	
	public List<GymSlot> getGymSlotsByGymCenter();
	
	public Boolean requestGymOwnerApproval();
	

}
