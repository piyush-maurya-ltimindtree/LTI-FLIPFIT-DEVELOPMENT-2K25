package com.lti.flipfit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/gymuser")
public class GymUserController {
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/register")
	public void register() {
		
	}

}
