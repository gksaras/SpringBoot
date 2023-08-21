package com.example.demo.controllers;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller - If we use @Controller we should specify @ResponseBody for every method
@RestController
public class HelloController {

	@GetMapping("/hello")
	//@ResponseBody
	public String hello() {
		return "Hello!";
	}
	
	@GetMapping("/kang")
	//@ResponseBody
	public String kang() {
		return "Kang!";
	}
	
}
