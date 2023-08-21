package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	private int empId;
	private String empName;
	
	// Many employees has one company address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
    public Employee(int empId, String empName, Address address){
        super();
        this.empId = empId;
        this.empName = empName;
        this.address = address;
    }
 
    public Employee() { super(); }
	
	
    public int getEmpId() { 
    	return empId; 
    }
 
    public void setEmpId(int empId) { 
    	this.empId = empId; 
    }
 
    public String getEmpName() {
    	return empName;
    }
 
    public void setEmpName(String empName)
    {
        this.empName = empName;
    }
 
    public Address getAddress() {
    	return address; 
    }
 
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    @Override public String toString()
    {
        return "Employee []";
    }
}

