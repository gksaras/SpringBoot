package com.spring.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aop.model.Employee;
import com.spring.aop.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

	 @Autowired
	    private EmployeeService employeeService;

	    @PostMapping("/add")
	    public Employee save(@RequestBody Employee employee ){
	        return employeeService.save(employee);
	    }

	    @GetMapping("/find/{id}")
	    public Employee findById( @PathVariable(value = "id") Integer id ){
	        return employeeService.findById(id);
	    }

}
