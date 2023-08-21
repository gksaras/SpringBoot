package com.spring.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.aop.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
