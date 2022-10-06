package com.qa.movieapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;


public class MovieUnitTest {

	Movie testMovie;
	
	@BeforeEach
	public void constructorMovie() {
		testMovie = new Movie(1, 120, "10");
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Movie.class).verify();
	}
}
