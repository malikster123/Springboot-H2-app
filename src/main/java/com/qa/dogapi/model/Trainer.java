package com.qa.dogapi.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trainer_id")

    private Integer trainerID;
    @Column(nullable = false)
    private String name;

    @Column
    private int age;


    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private List<Dog> dogs;


    public Trainer(Integer trainerID, String name, int age, List<Dog> dogs) {
        this.trainerID = trainerID;
        this.name = name;
        this.age = age;
        this.dogs = dogs;
    }

    
    public Trainer(String name, int age, List<Dog> dogs) {
        this.name = name;
        this.age = age;
        this.dogs = dogs;
    }
    
    public Trainer(){

    }
    
    public Integer getId() {
        return this.trainerID;
    }

    public void setId(Integer id) {
        this.trainerID = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trainer)) {
            return false;
        }
        Trainer trainer = (Trainer) o;
        return Objects.equals(trainerID, trainer.trainerID) && age == trainer.age && Objects.equals(name, trainer.name);
    }

    public Integer getTrainerID() {
        return this.trainerID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public List<Dog> getDogs() {
        return this.dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }


    @Override
    public int hashCode() {
        return Objects.hash(trainerID, age, name);
    }

}
