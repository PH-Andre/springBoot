package br.guilherme.apipointsofinterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiPointsOfInterestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPointsOfInterestApplication.class, args);
		System.out.println("Running on port 8080");
	}

}
													