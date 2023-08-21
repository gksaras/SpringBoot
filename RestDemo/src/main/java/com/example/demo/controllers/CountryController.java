package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;

// sending objects as response body
@RestController
public class CountryController {

//	@GetMapping("/korea")
//	public Country korea() {
//		Country c = Country.of("Korea",70);
//		return c;
//	}
//	
//	
//	@GetMapping("/all")
//	public List<Country> countries(){
//		
//		Country c1 = Country.of("India", 100);
//		Country c2 = Country.of("Japan", 50);
//		
//		return List.of(c1,c2);
//	}
	
	//setting response status and headers
	
	@GetMapping("/korea")
	public ResponseEntity<Country> korea(){
		Country c = Country.of("Korea",70);
		
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("continent", "Asia")
				.header("capital", "Seoul")
				.body(c);
	}
}
