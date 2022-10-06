package com.qa.movieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieApiApplication.class, args);
	}

	@Bean
	public void helloWorld() {
		System.out.println("Hello World");
	}
}
