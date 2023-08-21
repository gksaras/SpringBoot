package com.franchise.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franchise.model.Marvel;
import com.franchise.repository.MarvelRepository;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Slf4j
@RequestMapping("/api")
public class MarvelController {
	
	    @Autowired
	    MarvelRepository marvelRepository;

	    @GetMapping("/marvel")
	    public ResponseEntity<List<Marvel>> getAllMarvel(@RequestParam(required = false) String movie){
	        try{
	            List<Marvel> marvel = new ArrayList<>();
	            if (movie==null)
	            	marvelRepository.findAll().forEach(marvel::add);
	            else
	            	marvelRepository.findByMovie(movie).forEach(marvel::add);

	            if(marvel.isEmpty()){
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(marvel,HttpStatus.OK);
	        }catch (Exception e){
	            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    @PostMapping("/marvel")
	    public ResponseEntity<Marvel> addMarvel(@RequestBody Marvel marvel){
	        try{
	        	Marvel addMarvel = marvelRepository.save(new Marvel(marvel.getPhase(),marvel.getMovie(),marvel.getDepict(),marvel.isPosted()));
	            return new ResponseEntity<>(addMarvel,HttpStatus.CREATED);
	        }catch (Exception e){
	            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/marvel/id")
	    public ResponseEntity<Marvel> getMarvelById(@PathVariable("id") long id){
	        Optional<Marvel> marvelData = marvelRepository.findById(id);
	        if (marvelData.isPresent())
	            return new ResponseEntity<>(marvelData.get(),HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PutMapping("/marvel/{id}")
	    public ResponseEntity<Marvel> updateMarvel(@PathVariable("id") long id,@RequestBody Marvel marvel){
	        Optional<Marvel> marvelData = marvelRepository.findById(id);
	        if (marvelData.isPresent()){
	        	Marvel _marvel = marvelData.get();
	        	_marvel.setMovie(marvel.getMovie());
	        	_marvel.setDepict(marvel.getDepict());
	            _marvel.setPosted(marvel.isPosted());
	            return new ResponseEntity<>(marvelRepository.save(_marvel),HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/marvel/{id}")
	    public ResponseEntity<HttpStatus> deleteMarvel(@PathVariable("id") long id) {
	        try {
	        	marvelRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/marvel")
	    public ResponseEntity<HttpStatus> deleteAllMarvel() {
	        try {
	            marvelRepository.deleteAll();
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/marvel/posted")
	    public ResponseEntity<List<Marvel>> findByPosted() {
	        try {
	            List<Marvel> marvelList = marvelRepository.findByPosted(true);

	            if (marvelList.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(marvelList, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
