package com.lti.flipfit.services;

import com.lti.flipfit.beans.GymScheduler;

public interface SchedulerService {
	
	public GymScheduler createSchedule();
	public GymScheduler getScheduleDetails();
	public Boolean isScheduled();
	public GymScheduler modifySchedule();
	public Boolean checkAvailability();

}
