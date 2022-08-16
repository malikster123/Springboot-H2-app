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
import com.qa.dogapi.model.Trainer;
import com.qa.dogapi.repository.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	TrainerService service;

	public TrainerController(TrainerService service) {
		this.service = service;
	}

	@GetMapping("/test")
	public String test() {
		return "Hello, World!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		return new ResponseEntity<List<Trainer>>(service.getAllTrainers(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get")
	public ResponseEntity<Trainer> getTrainer() {
		return new ResponseEntity<Trainer>(service.getTrainer(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable Integer id) {
		return new ResponseEntity<Trainer>(service.getTrainer(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/createTrainer")
	public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
	
		return new ResponseEntity<Trainer>(service.addTrainer(trainer), HttpStatus.ACCEPTED);

	}

	@PostMapping("/updateTrainer/{id}")
	public ResponseEntity<Trainer> updateTrainerById(@RequestBody Trainer trainer, @PathVariable Integer id) {
		return new ResponseEntity<Trainer>(service.updateTrainer(id, trainer), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteTrainer/{id}")
	public ResponseEntity<Boolean> deleteTrainerById(@PathVariable Integer id) {
		return (this.service.deleteTrainerById(id) ? new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED)
				: new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND));

	}

}
