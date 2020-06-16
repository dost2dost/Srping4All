package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.exceptions","com.movies"})
public class SpringforallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringforallApplication.class, args);
	}

}
