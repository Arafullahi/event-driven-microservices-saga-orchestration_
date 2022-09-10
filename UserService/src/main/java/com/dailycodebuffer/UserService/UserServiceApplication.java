package com.dailycodebuffer.UserService;

import com.dailycodebuffer.UserService.command.api.exception.UserServiceErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler(
				"user",
				configuration -> new UserServiceErrorHandler()
		);
	}
}
