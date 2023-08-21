package com.spring.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aop.model.Department;
import com.spring.aop.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	    @Autowired
	    private DepartmentService departmentService;

	    @PostMapping("/add")
	    public Department save( @RequestBody Department department ){
	        return departmentService.save(department);
	    }

	    @GetMapping("/find/{id}")
	    public Department findById( @PathVariable(value = "id") Integer id ){
	        return departmentService.findById(id);
	    }
}
