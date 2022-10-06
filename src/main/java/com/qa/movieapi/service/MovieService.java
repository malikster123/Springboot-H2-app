package com.qa.movieapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.movieapi.model.Movie;
import com.qa.movieapi.repository.MovieRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

	@Autowired
	private MovieRepo repo;


	public MovieService(MovieRepo repo) {
		this.repo=repo;
	}
	
	public Movie addMovie(Movie movie) {
		return repo.save(movie);
	}

	public List<Movie> getAllMovies(){
		return repo.findAll();
	}

	public Movie getMovie(){
		return repo.findLatestMovie();
	}


	public Movie getDogByID(Integer id){

		Optional<Movie> existingOptional = Optional.of(this.repo.getReferenceById(id));

		if (existingOptional.isPresent()) {
			return existingOptional.get();
		}

		return null;

	}


	public Movie updateMovie(Integer id, Movie newMovie) {
        Optional<Movie> existingOptional = Optional.of(this.repo.getReferenceById(id));

        if (existingOptional.isPresent()) {
        	Movie existing = existingOptional.get();
            existing.setruntimeMin(newMovie.getruntimeMin());
            existing.setName(newMovie.getName());
            return this.repo.save(existing);
		}
		return null;
    }


	public boolean deleteMovieById(Integer id) {
        Optional<Movie> existingOptional = Optional.of(this.repo.getReferenceById(id));

        if (existingOptional.isPresent()) {
        	Movie movie = existingOptional.get();
        	this.repo.delete(movie);
        	return true;
		}

		return false;
    }
}
