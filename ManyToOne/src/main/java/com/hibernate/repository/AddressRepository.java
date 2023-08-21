package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
