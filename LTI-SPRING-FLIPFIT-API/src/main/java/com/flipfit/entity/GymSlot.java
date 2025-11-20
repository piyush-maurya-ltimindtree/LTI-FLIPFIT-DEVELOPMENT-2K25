package com.flipfit.entity;

import java.time.LocalDateTime;

public class GymSlot {
	
	private Long slotId;
	private Long gymCenterId;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Integer capacity;
	private Integer availableSeats;
	
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public Long getGymCenterId() {
		return gymCenterId;
	}
	public void setGymCenterId(Long gymCenterId) {
		this.gymCenterId = gymCenterId;
	}
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	

}
