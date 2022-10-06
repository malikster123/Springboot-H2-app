package com.qa.movieapi.model;


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
@Table(name="movie")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private Integer movieID;
	
	@Min(0)
	@Max(300)
	@Column
	private int runtimeMin;
	
	@Column
	@Size(min = 1, max = 40)
	private String name;

	
	
	@ManyToOne
	@JoinColumn(name = "director_id", referencedColumnName="director_id", updatable=false)
	Director director;

    public Movie(){

    }

	public Movie(Integer id, int runtimeMin,  String name) {
		this.movieID = id;
		this.runtimeMin = runtimeMin;
		this.name = name;
	}


	public Movie(int runtimeMin,  String name) {
		this.runtimeMin = runtimeMin;
		this.name = name;
	}

	
	public Movie(int runtimeMin,  String name,
			 String email, Director director) {
		this.runtimeMin = runtimeMin;
		this.name = name;
		this.director=director;
	}



	public Integer getmovieID() {
		return this.movieID;
	}

	public void setmovieID(Integer movieID) {
		this.movieID = movieID;
	}

	public Director getDirector() {
		return this.director;
	}

	public void setTrainer(Director director) {
		this.director = director;
	}


	public Integer getId() {
		return movieID;
	}


	public void setId(Integer id) {
		this.movieID = id;
	}


	public int getruntimeMin() {
		return runtimeMin;
	}

	public void setruntimeMin(int runtimeMin) {
		this.runtimeMin = runtimeMin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, runtimeMin);
	}
	
	
	
	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", runtimeMin=" + runtimeMin + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(name, other.name) && runtimeMin == other.runtimeMin;
	}


	
	
}
