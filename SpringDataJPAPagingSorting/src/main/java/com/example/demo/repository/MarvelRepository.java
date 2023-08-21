package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Marvel;

public interface MarvelRepository extends JpaRepository<Marvel, Long> {

	Page<Marvel> findByPublished(boolean published,Pageable pageable);
	
	Page<Marvel> findByFranchise(String franchise,Pageable pageable);
	
	List<Marvel> findByFranchise(String franchise,Sort sort);
}
