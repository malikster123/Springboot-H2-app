package com.qa.dogapi.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.dogapi.model.Trainer;

@Service
public class TrainerService{
    
    @Autowired
    TrainerRepo repo;

    public TrainerService(TrainerRepo repo) {
        this.repo = repo;
    }

    public Trainer addTrainer(Trainer trainer){
       return repo.save(trainer);
    }

    public List<Trainer> getAllTrainers(){
		return repo.findAll();
	}

    
    public Trainer getTrainer(){
		return repo.findLatestTrainer();
	}

    
	public Trainer getTrainerByID(Integer id){
	
		Optional<Trainer> existingOptional = Optional.of(this.repo.getReferenceById(id));
		
		if (existingOptional.isPresent()) {
			return existingOptional.get();
		}
		
		return null;
	
	}	
    
	public Trainer updateTrainer(Integer id, Trainer newTrainer) {
        Optional<Trainer> existingOptional = Optional.of(this.repo.getReferenceById(id));
        
        if (existingOptional.isPresent()) {
        	Trainer existing = existingOptional.get();
            existing.setAge(newTrainer.getAge());
            existing.setName(newTrainer.getName());
            return this.repo.save(existing);
		}
        
		return null;      
    }

	public boolean deleteTrainerById(Integer id) {
        Optional<Trainer> existingOptional = Optional.of(this.repo.getReferenceById(id));
        
        if (existingOptional.isPresent()) {
        	Trainer Trainer = existingOptional.get();
        	this.repo.delete(Trainer);
        	return true;
		}
        
		return false;      
    }
	
}