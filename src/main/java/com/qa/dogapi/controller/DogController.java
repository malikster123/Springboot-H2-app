package com.qa.dogapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dogapi.model.Dog;
import com.qa.dogapi.repository.DogService;

@RestController
@RequestMapping("/dog")
public class DogController {

	DogService service;

	public DogController(DogService service) {
		this.service = service;
	}

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return new ResponseEntity<List<Dog>>(service.getAllDogs(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<Dog> getDog() {
		return new ResponseEntity<Dog>(service.getDog(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Dog> getDogById(@PathVariable Integer id) {
		return new ResponseEntity<Dog>(service.getDog(), HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/createDog")
	public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
		return new ResponseEntity<Dog>(service.addDog(dog), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/updateDog/{id}")
	public ResponseEntity<Dog> updateDogById(@RequestBody Dog dog, @PathVariable Integer id) {
		return new ResponseEntity<Dog>(service.updateDog(id, dog), HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/deleteDog/{id}")
	public ResponseEntity<Boolean> deleteDogById(@PathVariable Integer id) {		
		return (this.service.deleteDogById(id) ?
				new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED):
				new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND));
		
	}
	
	

}
