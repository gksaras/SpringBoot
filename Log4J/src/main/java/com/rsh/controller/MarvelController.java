package com.rsh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarvelController {

	Logger logger = LoggerFactory.getLogger(MarvelController.class);

	@GetMapping("/")
	public String getMessage() {
		
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		System.out.println(10/0);
		
		return "Hello Marvel!";
	}
}
