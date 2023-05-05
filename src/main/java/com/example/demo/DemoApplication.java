package com.example.demo;

import com.example.demo.jpa.*;
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
	public CommandLineRunner demo(EGGUserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
		return (args) -> {

			initializeDB(userRepository, roleRepository, permissionRepository);
			log.info("Finished");
		};
	}

	private void initializeDB (EGGUserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
		log.info("Delete all data");
		userRepository.deleteAll();
		roleRepository.deleteAll();
		permissionRepository.deleteAll();

		log.info("----- Creating users");
		userRepository.save(new EGGUser("Jörn", "Schmidt"));
		userRepository.save(new EGGUser("Max", "Mustermann"));
		userRepository.save(new EGGUser("Daniel", "Müller"));

		log.info("----- Creating roles");
		Role hraBesitzer = new Role("HRA_Besitzer");
		Role mitwirkende = new Role("HRA_Mitwirkende");
		Role teilnehmer = new Role("HRA_Teilnehmer");

		roleRepository.save(hraBesitzer);
		roleRepository.save(mitwirkende);
		roleRepository.save(new Role("Stellvertreter"));
		roleRepository.save(teilnehmer);
		roleRepository.save(new Role("Fachadministrator"));

		log.info("----- Creating permissions");
		permissionRepository.save(new Permission(hraBesitzer, "Bearbeiten"));
		permissionRepository.save(new Permission(hraBesitzer, "Lesen"));
		permissionRepository.save(new Permission(teilnehmer, "Unterabstimmung einleiten"));
		permissionRepository.save(new Permission(teilnehmer, "Info zur Abstimmung lesen"));
	}

}
