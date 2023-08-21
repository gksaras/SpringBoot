package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByPublished(boolean published);	// returns all tutorials with published having value as input published
	List<Tutorial> findByTitleContaining(String title); // returns all tutorials which title contains input title
}

