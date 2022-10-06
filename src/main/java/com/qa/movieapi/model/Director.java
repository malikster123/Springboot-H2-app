package com.qa.movieapi.model;

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
@Table(name="director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="director_id")

    private Integer DirectorID;
    @Column(nullable = false)
    private String name;

    @Column
    private int age;


    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private List<Movie> movies;


    public Director(Integer DirectorID, String name, int age, List<Movie> movie) {
        this.DirectorID = DirectorID;
        this.name = name;
        this.age = age;
        this.movies = movies;
    }

    
    public Director(String name, int age, List<Movie> movie) {
        this.name = name;
        this.age = age;
        this.movies = movies;
    }
    
    public Director(){

    }
    
    public Integer getId() {
        return this.DirectorID;
    }

    public void setId(Integer id) {
        this.DirectorID = id;
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
        if (!(o instanceof Director)) {
            return false;
        }
        Director director = (Director) o;
        return Objects.equals(DirectorID, director.DirectorID) && age == director.age && Objects.equals(name, director.name);
    }

    public Integer getDirectorID() {
        return this.DirectorID;
    }

    public void setDirectorID(Integer DirectorID) {
        this.DirectorID = DirectorID;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public void setDogs(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public int hashCode() {
        return Objects.hash(DirectorID, age, name);
    }

}
