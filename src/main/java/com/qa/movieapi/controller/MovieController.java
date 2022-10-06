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

import com.qa.movieapi.model.Movie;
import com.qa.movieapi.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(service.getAllMovies(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<Movie> getMovies() {
		return new ResponseEntity<Movie>(service.getMovie(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
		return new ResponseEntity<Movie>(service.getMovie(), HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/createMovie")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(service.addMovie(movie), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/updateMovie/{id}")
	public ResponseEntity<Movie> updateMovieById(@RequestBody Movie movie, @PathVariable Integer id) {
		return new ResponseEntity<Movie>(service.updateMovie(id, movie), HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/deleteMovie/{id}")
	public ResponseEntity<Boolean> deleteDogById(@PathVariable Integer id) {		
		return (this.service.deleteMovieById(id) ?
				new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED):
				new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND));
		
	}
	
	

}
