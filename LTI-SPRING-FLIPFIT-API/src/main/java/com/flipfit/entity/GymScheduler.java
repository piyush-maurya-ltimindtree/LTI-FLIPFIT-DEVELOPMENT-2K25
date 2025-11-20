package com.flipfit.entity;

import java.time.LocalDateTime;

public class GymScheduler {
	
	private Long scheduleId;
	private Long slotId;
	private LocalDateTime slotDateTime;
	private Boolean availability;
	
	
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	public LocalDateTime getSlotDateTime() {
		return slotDateTime;
	}
	public void setSlotDateTime(LocalDateTime slotDateTime) {
		this.slotDateTime = slotDateTime;
	}
	

}
