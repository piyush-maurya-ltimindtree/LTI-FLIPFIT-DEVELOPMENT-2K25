package com.flipfit.service;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;

import java.util.List;


public interface GymCenterService {
	
	public List<GymSlot> getSlots();
	public Boolean getAvailability();
	public GymCenter getGymCenterByCity(String city);
	public Boolean requestGymCenterApproval(Long gymCenterId);
	

}
