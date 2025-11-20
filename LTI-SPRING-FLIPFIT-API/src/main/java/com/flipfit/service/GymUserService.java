package com.flipfit.service;


import com.flipfit.entity.GymUser;

/**
 * @author Mayuresh Arvind Gujar
 */
public interface GymUserService {
	
	public Boolean login(GymUser gymUser);
	
	public void register(GymUser gymUser);


}
