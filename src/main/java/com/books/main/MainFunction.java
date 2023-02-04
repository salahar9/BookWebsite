package com.books.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.books.models")
@EnableJpaRepositories("com.books.repository")
@ComponentScan("com.books.*")
@SpringBootApplication
public class MainFunction {

	public static void main(String[] args) {
		SpringApplication.run(MainFunction.class, args);

	}

}