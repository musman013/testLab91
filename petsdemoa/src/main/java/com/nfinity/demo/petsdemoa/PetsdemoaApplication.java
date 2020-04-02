package com.nfinity.demo.petsdemoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PetsdemoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsdemoaApplication.class, args);
	}

}

