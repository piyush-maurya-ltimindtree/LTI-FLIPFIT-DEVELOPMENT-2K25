package com.lti.flipfit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymSlot;

@Service
public class GymCenterServiceImpl implements GymCenterService {

	@Override
	public List<GymSlot> getSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getAvailability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GymCenter getGymCenterByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean requestGymCenterApproval(Long gymCenterId) {
		// TODO Auto-generated method stub
		return null;
	}

}
