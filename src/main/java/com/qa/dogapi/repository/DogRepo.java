package com.qa.dogapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.dogapi.model.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {
	
	@Query(value = "SELECT * FROM dog limit 1", nativeQuery=true)
	public Dog findLatestDog();
	
	@Query(value="SELECT * FROM dog WHERE name = ?1 AND age = ?2 LIMIT 1", nativeQuery=true)
	public Dog findSpecificDog(String name, int age);
	
	@Query(value = "UPDATE dog SET id=?1, name=?2, age=?3, email=?4 WHERE id=?5", nativeQuery=true)
	public Dog updateDog(Dog dog);
}

