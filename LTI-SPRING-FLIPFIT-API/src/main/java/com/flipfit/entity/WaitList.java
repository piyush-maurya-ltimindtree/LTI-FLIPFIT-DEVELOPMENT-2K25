package com.flipfit.entity;

public class WaitList {

	private Long waitListId;
	private Long slotId;
	private Long userId;
	private Integer position;
	
	public Long getWaitListId() {
		return waitListId;
	}
	public void setWaitListId(Long waitListId) {
		this.waitListId = waitListId;
	}
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
