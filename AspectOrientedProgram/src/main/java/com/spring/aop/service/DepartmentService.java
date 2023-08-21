package com.spring.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.annotation.CustomAnnotation;
import com.spring.aop.model.Department;
import com.spring.aop.repository.DepartmentRepository;

@Service
public class DepartmentService {

	   @Autowired
	    private DepartmentRepository departmentRepository;

	    public Department save( Department department ){
	        return departmentRepository.save(department);
	    }

	    @CustomAnnotation
	    public Department findById(Integer id ){
	        return departmentRepository.findById(id).orElse(null);
	    }

}
