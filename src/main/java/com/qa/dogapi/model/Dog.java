package com.qa.dogapi.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name="dog")
public class Dog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dog_id")
	private Integer dogID;
	
	@Min(0)
	@Max(28)
	@Column
	private int age;
	
	@Column
	@Size(min = 2, max = 20)
	private String name;

	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id", referencedColumnName="trainer_id", updatable=false)
	Trainer trainer;

    public Dog(){

    }

	public Dog(Integer id, int age,  String name,
			 String email) {
		this.dogID = id;
		this.age = age;
		this.name = name;
		this.email = email;
	}


	public Dog(int age,  String name,
			 String email) {
		this.age = age;
		this.name = name;
		this.email = email;
	}

	
	public Dog(int age,  String name,
			 String email, Trainer trainer) {
		this.age = age;
		this.name = name;
		this.email = email;
		this.trainer=trainer;
	}



	public Integer getDogID() {
		return this.dogID;
	}

	public void setDogID(Integer dogID) {
		this.dogID = dogID;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	public Integer getId() {
		return dogID;
	}


	public void setId(Integer id) {
		this.dogID = id;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Dog [id=" + dogID + ", age=" + age + ", name=" + name + ", email=" + email + "]";
	}



	
	
}
