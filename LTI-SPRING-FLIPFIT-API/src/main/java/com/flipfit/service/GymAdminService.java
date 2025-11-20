package com.flipfit.service;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymOwner;

import java.util.List;


public interface GymAdminService {
	
	public Boolean validateGymOwner();
	
	public Boolean validateGymCenter();

	public List<GymOwner> viewPendingGymOwnerRequests();
	
	public List<GymCenter> viewPendingGymCenterRequests();
	
	public String generateReport();
	

}
