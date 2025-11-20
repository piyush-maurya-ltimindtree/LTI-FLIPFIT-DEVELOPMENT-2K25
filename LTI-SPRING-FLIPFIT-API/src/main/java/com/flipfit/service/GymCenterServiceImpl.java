package com.flipfit.service;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;
import org.springframework.stereotype.Service;



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
