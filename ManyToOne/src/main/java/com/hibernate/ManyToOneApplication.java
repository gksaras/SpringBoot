package com.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.repository.AddressRepository;
import com.hibernate.repository.EmployeeRepository;

@SpringBootApplication
public class ManyToOneApplication implements CommandLineRunner{
	

    @Autowired AddressRepository addressRepository;
    @Autowired EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		  
		Address address = new Address(1, "Bangloor");
	        addressRepository.save(address);
	 
	        Employee emp1 = new Employee(1, "Alpha", address);
	        Employee emp2 = new Employee(2, "Beeta", address);
	 
	        employeeRepository.save(emp1);
	        employeeRepository.save(emp2);
	}

}
