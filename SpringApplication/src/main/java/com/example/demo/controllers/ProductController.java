package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public String viewProducts(Model model) {
		
		List<Product> products = productService.findAll();
		
		model.addAttribute("products", products);
		
		return "products.html";
	}
	
	@PostMapping("/products")
	public String addProduct(
		@RequestParam String name,
		@RequestParam double price,
		Model model)
	{
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		productService.addProduct(p);
		
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
			
		return "products.html";
	}
}
