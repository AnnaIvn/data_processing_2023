package ua.knu.fit.mit.lab5;

import components.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Lab5Application {

	@Autowired
	Sample sample;

	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}

}
