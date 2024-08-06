package com.qa.sky.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// spring starts looking for components wherever this annotation is
public class Sky3SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sky3SpringApplication.class, args);
	}

}
