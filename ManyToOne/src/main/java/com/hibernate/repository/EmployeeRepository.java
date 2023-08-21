package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
