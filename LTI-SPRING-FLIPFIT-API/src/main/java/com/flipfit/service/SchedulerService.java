package com.flipfit.service;


import com.flipfit.entity.GymScheduler;

public interface SchedulerService {
	
	public GymScheduler createSchedule();
	public GymScheduler getScheduleDetails();
	public Boolean isScheduled();
	public GymScheduler modifySchedule();
	public Boolean checkAvailability();

}
