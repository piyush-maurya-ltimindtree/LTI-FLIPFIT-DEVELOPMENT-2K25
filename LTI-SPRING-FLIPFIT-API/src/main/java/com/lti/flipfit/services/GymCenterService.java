package com.lti.flipfit.services;

import java.util.List;

import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymSlot;

public interface GymCenterService {
	
	public List<GymSlot> getSlots();
	public Boolean getAvailability();
	public GymCenter getGymCenterByCity(String city);
	public Boolean requestGymCenterApproval(Long gymCenterId);
	

}
