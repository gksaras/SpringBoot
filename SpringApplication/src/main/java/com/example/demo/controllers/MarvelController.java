package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Marvel;

@Controller
@RequestMapping("/marvel")
public class MarvelController {

	private static List<Marvel> marvel = new ArrayList<>();
	
	static{
		Marvel m1 = new Marvel(4, "Black-Widow");
		Marvel m2 = new Marvel(5, "Quantumania");
		Marvel m3 = new Marvel(6, "Secret-Wars");
		
		marvel.add(m1);
		marvel.add(m2);
		marvel.add(m3);
	}
	
	@GetMapping
	public String getMarvel(Model model) {
		model.addAttribute("marvel", marvel);
		return "marvel";
	}
}
