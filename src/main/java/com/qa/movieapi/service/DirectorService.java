package com.qa.movieapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.movieapi.model.Director;
import com.qa.movieapi.repository.DirectorRepo;

@Service
public class DirectorService{
    
    @Autowired
    DirectorRepo repo;

    public DirectorService(DirectorRepo repo) {
        this.repo = repo;
    }

    public Director addDirector(Director director){
       return repo.save(director);
    }

    public List<Director> getAllDirector(){
		return repo.findAll();
	}

    
    public Director getDirector(){
		return repo.findLatestDirector();
	}

    
	public Director getDirectorByID(Integer id){
	
		Optional<Director> existingOptional = Optional.of(this.repo.getReferenceById(id));
		
		if (existingOptional.isPresent()) {
			return existingOptional.get();
		}
		
		return null;
	
	}	
    
	public Director updateDirector(Integer id, Director newDirector) {
        Optional<Director> existingOptional = Optional.of(this.repo.getReferenceById(id));
        
        if (existingOptional.isPresent()) {
        	Director existing = existingOptional.get();
            existing.setAge(newDirector.getAge());
            existing.setName(newDirector.getName());
            return this.repo.save(existing);
		}
        
		return null;      
    }

	public boolean deleteDirectorById(Integer id) {
        Optional<Director> existingOptional = Optional.of(this.repo.getReferenceById(id));
        
        if (existingOptional.isPresent()) {
        	Director Director = existingOptional.get();
        	this.repo.delete(Director);
        	return true;
		}
        
		return false;      
    }
	
}