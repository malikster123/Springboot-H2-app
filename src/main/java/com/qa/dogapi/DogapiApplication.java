package com.qa.dogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DogapiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DogapiApplication.class, args);
	}

	@Bean
	public void helloWorld() {
		System.out.println("Hello World");
	}
}
