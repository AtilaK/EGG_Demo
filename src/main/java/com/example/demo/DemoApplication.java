package com.example.demo;

import com.example.demo.jpa.Customer;
import com.example.demo.jpa.CustomerRepository;
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

			// save a few customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");

			// fetch an individual customer by ID
//			Customer customer = repository.findById(102L);
//			log.info("Customer found with findById(102L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");

			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}

	private void initializeDB (EGGUserRepository userRepository) {
		userRepository.deleteAll();
		userRepository.save(new EGGUser("Jörn", "Schmidt"));
		userRepository.save(new EGGUser("Max", "Mustermann"));
		userRepository.save(new EGGUser("Daniel", "Müller"));
	}

}
