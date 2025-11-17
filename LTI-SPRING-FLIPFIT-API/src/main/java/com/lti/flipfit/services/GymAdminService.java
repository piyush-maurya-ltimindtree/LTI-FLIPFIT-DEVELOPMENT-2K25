package com.lti.flipfit.services;

import java.util.List;

import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymOwner;

public interface GymAdminService {
	
	public Boolean validateGymOwner();
	
	public Boolean validateGymCenter();

	public List<GymOwner> viewPendingGymOwnerRequests();
	
	public List<GymCenter> viewPendingGymCenterRequests();
	
	public String generateReport();
	

}
