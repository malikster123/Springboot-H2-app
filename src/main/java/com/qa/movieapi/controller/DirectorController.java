package com.qa.movieapi.controller;

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

import com.qa.movieapi.model.Director;
import com.qa.movieapi.service.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {
	DirectorService service;

	public DirectorController(DirectorService service) {
		this.service = service;
	}

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Director>> getAllDirectors() {
		return new ResponseEntity<List<Director>>(service.getAllDirector(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get")
	public ResponseEntity<Director> getDirectors() {
		return new ResponseEntity<Director>(service.getDirector(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Director> getDirectorById(@PathVariable Integer id) {
		return new ResponseEntity<Director>(service.getDirector(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/createDirector")
	public ResponseEntity<Director> createDirector(@RequestBody Director director) {
	
		return new ResponseEntity<Director>(service.addDirector(director), HttpStatus.ACCEPTED);

	}

	@PostMapping("/updateDirector/{id}")
	public ResponseEntity<Director> updateTrainerById(@RequestBody Director director, @PathVariable Integer id) {
		return new ResponseEntity<Director>(service.updateDirector(id, director), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteTrainer/{id}")
	public ResponseEntity<Boolean> deleteDirectorById(@PathVariable Integer id) {
		return (this.service.deleteDirectorById(id) ? new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED)
				: new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND));

	}

}
