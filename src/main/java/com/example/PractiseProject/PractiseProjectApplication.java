package com.example.PractiseProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PractiseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseProjectApplication.class, args);
	}

}
