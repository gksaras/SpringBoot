package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TutorialDetails;

@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long>{

	 @Transactional
	  void deleteById(long id);
	  
	  @Transactional
	  void deleteByTutorialId(long tutorialId);
	
}
