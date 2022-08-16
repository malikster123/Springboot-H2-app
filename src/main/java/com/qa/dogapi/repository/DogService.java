package com.qa.dogapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.dogapi.model.Dog;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

	@Autowired
	private DogRepo repo;


	public DogService(DogRepo repo) {
		this.repo=repo;
	}
	
	public Dog addDog(Dog dog) {
		return repo.save(dog);
	}

	public List<Dog> getAllDogs(){
		return repo.findAll();
	}

	public Dog getDog(){
		return repo.findLatestDog();
	}


	public Dog getDogByID(Integer id){

		Optional<Dog> existingOptional = Optional.of(this.repo.getReferenceById(id));

		if (existingOptional.isPresent()) {
			return existingOptional.get();
		}

		return null;

	}


	public Dog updateDog(Integer id, Dog newDog) {
        Optional<Dog> existingOptional = Optional.of(this.repo.getReferenceById(id));

        if (existingOptional.isPresent()) {
        	Dog existing = existingOptional.get();
            existing.setAge(newDog.getAge());
            existing.setName(newDog.getName());
            existing.setEmail(newDog.getEmail());
            return this.repo.save(existing);
		}
		return null;
    }


	public boolean deleteDogById(Integer id) {
        Optional<Dog> existingOptional = Optional.of(this.repo.getReferenceById(id));

        if (existingOptional.isPresent()) {
        	Dog dog = existingOptional.get();
        	this.repo.delete(dog);
        	return true;
		}

		return false;
    }
}
