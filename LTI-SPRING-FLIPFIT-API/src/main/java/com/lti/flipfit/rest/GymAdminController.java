package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymOwner;


@RestController
@RequestMapping("/api/gymadmin")
public class GymAdminController {
	
	public Boolean validateGymOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean validateGymCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<GymOwner> viewPendingGymOwnerRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<GymCenter> viewPendingGymCenterRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String generateReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
