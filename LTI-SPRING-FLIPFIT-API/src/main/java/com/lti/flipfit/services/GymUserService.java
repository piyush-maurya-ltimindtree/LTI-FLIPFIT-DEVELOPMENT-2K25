package com.lti.flipfit.services;

import com.lti.flipfit.beans.GymUser;
/**
 * @author Mayuresh Arvind Gujar
 */
public interface GymUserService {
	
	public Boolean login(GymUser gymUser);
	
	public void register(GymUser gymUser);


}
