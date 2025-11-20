package com.lti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {
        "com.lti.flipfit.rest",
        "com.lti.flipfit.services",
        "com.lti.flipfit.beans",
        "com.lti.flipfit.exception"
})

public class LtiFlipFitSpringMicroservicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtiFlipFitSpringMicroservicesApiApplication.class, args);
	}

}
