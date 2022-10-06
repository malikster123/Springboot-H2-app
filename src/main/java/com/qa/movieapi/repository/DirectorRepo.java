package com.qa.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.movieapi.model.Director;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Integer>{
	
    @Query(value = "SELECT * FROM trainer limit 1", nativeQuery=true)
	public Director findLatestDirector();
    
}
