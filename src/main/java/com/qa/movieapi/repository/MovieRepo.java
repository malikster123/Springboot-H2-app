package com.qa.movieapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.movieapi.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query(value = "SELECT * FROM dog limit 1", nativeQuery=true)
	public Movie findLatestMovie();
	
	@Query(value="SELECT * FROM dog WHERE name = ?1 AND age = ?2 LIMIT 1", nativeQuery=true)
	public Movie findSpecifiMovie(String name, int age);
	
	@Query(value = "UPDATE dog SET id=?1, name=?2, age=?3, email=?4 WHERE id=?5", nativeQuery=true)
	public Movie updateMovie(Movie movie);
}

