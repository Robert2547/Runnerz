package com.example.demo;

import java.time.LocalDateTime;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.run.Location;
import com.example.demo.run.Run;
import com.example.demo.run.RunRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class Application {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean // Bean is a method that returns an object that Spring manages
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5,
	// 				Location.OUTDOOR);
	// 		runRepository.create(run);  
	// 	};
	// }
}
