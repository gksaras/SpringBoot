package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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

import com.example.demo.model.Marvel;
import com.example.demo.repository.MarvelRepository;

@CrossOrigin(origins = "http://loaclhost:8081")
@RestController
@RequestMapping("/api")
public class MarvelController {

	@Autowired
	MarvelRepository marvelRepository;
	
	private Sort.Direction getSortDirection(String direction){
		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		}else if(direction.equals("desc")) {
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;
	}
	
	@GetMapping
	public ResponseEntity<List<Marvel>> getAllMarvels(@RequestParam(defaultValue = "id,desc") String[] sort){
		try {
			List<Order> orders = new ArrayList<Order>();
			if (sort[0].contains(",")) {
				for(String sortOrder : sort) {
					String[] _sort = sortOrder.split(",");
					orders.add(new Order(getSortDirection(_sort[1]),_sort[0]));
					
				}
			}else {
				orders.add(new Order(getSortDirection(sort[1]),sort[0]));
			}
			
			List<Marvel> marvels = marvelRepository.findAll(Sort.by(orders));
			
			if(marvels.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(marvels,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/marvels")
	  public ResponseEntity<Map<String, Object>> getAllMarvelsPage(
	      @RequestParam(required = false) String title,
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size,
	      @RequestParam(defaultValue = "id,desc") String[] sort) {

	    try {
	      List<Order> orders = new ArrayList<Order>();

	      if (sort[0].contains(",")) {
	        // will sort more than 2 fields
	        // sortOrder="field, direction"
	        for (String sortOrder : sort) {
	          String[] _sort = sortOrder.split(",");
	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	      } else {
	        // sort=[field, direction]
	        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
	      }

	      List<Marvel> marvels = new ArrayList<Marvel>();
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

	      Page<Marvel> pageTuts;
	      if (title == null)
	        pageTuts = marvelRepository.findAll(pagingSort);
	      else
	        pageTuts = marvelRepository.findByFranchise(title, pagingSort);

	      marvels = pageTuts.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("marvels", marvels);
	      response.put("currentPage", pageTuts.getNumber());
	      response.put("totalItems", pageTuts.getTotalElements());
	      response.put("totalPages", pageTuts.getTotalPages());

	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/tutorials/published")
	  public ResponseEntity<Map<String, Object>> findByPublished(
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size) {
	    
	    try {
	      List<Marvel> marvels = new ArrayList<Marvel>();
	      Pageable paging = PageRequest.of(page, size);

	      Page<Marvel> pageTuts = marvelRepository.findByPublished(true, paging);
	      marvels = pageTuts.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("marvels", marvels);
	      response.put("currentPage", pageTuts.getNumber());
	      response.put("totalItems", pageTuts.getTotalElements());
	      response.put("totalPages", pageTuts.getTotalPages());

	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/marvels/{id}")
	  public ResponseEntity<Marvel> getMarvelById(@PathVariable("id") long id) {
	    Optional<Marvel> marvelData = marvelRepository.findById(id);

	    if (marvelData.isPresent()) {
	      return new ResponseEntity<>(marvelData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/marvels")
	  public ResponseEntity<Marvel> createMarvel(@RequestBody Marvel marvel) {
	    try {
	      Marvel _marvel = marvelRepository.save(new Marvel(marvel.getPhase(), marvel.getFranchise(), marvel.isPublished()));
	      return new ResponseEntity<>(_marvel, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/tutorials/{id}")
	  public ResponseEntity<Marvel> updateMarvel(@PathVariable("id") long id, @RequestBody Marvel marvel) {
	    Optional<Marvel> marvelData = marvelRepository.findById(id);

	    if (marvelData.isPresent()) {
	      Marvel _marvel = marvelData.get();
	      marvel.setPhase(marvel.getPhase());
	      marvel.setFranchise(marvel.getFranchise());
	      marvel.setPublished(marvel.isPublished());
	      return new ResponseEntity<>(marvelRepository.save(_marvel), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/marvels/{id}")
	  public ResponseEntity<HttpStatus> deleteMarvel(@PathVariable("id") long id) {
	    try {
	      marvelRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/marvels")
	  public ResponseEntity<HttpStatus> deleteAllMarvels() {
	    try {
	      marvelRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }	
}
