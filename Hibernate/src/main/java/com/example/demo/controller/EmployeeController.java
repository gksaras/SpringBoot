package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Hello Hibernate!";
	}
	
	@PostMapping("/add")
	public Employee saveData(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeee(@PathVariable int id) {
		Employee employee = employeeRepository.findById(id).get();
		if(employee!=null)
			employeeRepository.delete(employee);
		return "Delete Success";
	}
	
	@PutMapping("/putAll")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	@GetMapping("/getone/{rollno}")
	public Employee getEmployeeOne(@PathVariable int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee emp = employee.get();
		return emp;
	}
	
	@DeleteMapping("/deleteAll")
	public Employee deleteAllEmployee(@RequestBody Employee employee) {
		employeeRepository.deleteAll();
		return employee;
	}
}

