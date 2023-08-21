package com.franchise.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	private static final Logger log = Logger.getLogger(IndexController.class);

//	{
//		BasicConfigurator.configure();
//	}

	@GetMapping("/")
	public String index() {
		log.debug("loading index page...");
		return "index";
	}
}
