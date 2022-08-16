package com.qa.dogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.dogapi.model.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer>{
	
    @Query(value = "SELECT * FROM trainer limit 1", nativeQuery=true)
	public Trainer findLatestTrainer();
    
}
