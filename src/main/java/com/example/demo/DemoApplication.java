package com.example.demo;

import com.example.demo.jpa.EGGUser;
import com.example.demo.jpa.EGGUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EGGUserRepository userRepository) {
		return (args) -> {

			initializeDB(userRepository);
			log.info("Finished");
		};
	}

	private void initializeDB (EGGUserRepository userRepository) {
		log.info("Delete all users");
		userRepository.deleteAll();
		log.info("-------------------------------");
		userRepository.save(new EGGUser("Jörn", "Schmidt"));
		userRepository.save(new EGGUser("Max", "Mustermann"));
		userRepository.save(new EGGUser("Daniel", "Müller"));
	}

}
