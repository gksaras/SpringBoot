package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Address {

	@Id
	private int addressId;
	
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
	
	private List<Employee> employee = new ArrayList<>();
	
	public Address(int addressId, String location){
		super();
	    this.addressId = addressId;
	    this.location = location;
    }
	
	public Address() {
		
	}
	
	 public int getAddressId() { return addressId; }
	 
	    public void setAddressId(int addressId)
	    {
	        this.addressId = addressId;
	    }
	 
	    public String getLocation() { return location; }
	 
	    public void setLocation(String location)
	    {
	        this.location = location;
	    }
	 
	    public List<Employee> getEmployee() { return employee; }
	 
	    public void setEmployee(List<Employee> employee)
	    {
	        this.employee = employee;
	    }
}
