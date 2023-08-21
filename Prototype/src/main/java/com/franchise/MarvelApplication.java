package com.franchise;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarvelApplication {


	private static final Logger logger = LogManager.getLogger(MarvelApplication.class);  
	
	public static void main(String[] args) {
		
		SpringApplication.run(MarvelApplication.class, args);
		
		  // basic log4j configuration  
		  BasicConfigurator.configure();  
		  logger.info("Hello world");  
		  logger.info("we are in logger info mode");  
	}

}
