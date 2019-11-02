package com.example.WineListProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.WineListProject.domain.Category;
import com.example.WineListProject.domain.CategoryRepository;
import com.example.WineListProject.domain.User;
import com.example.WineListProject.domain.UserRepository;
import com.example.WineListProject.domain.Wine;
import com.example.WineListProject.domain.WineRepository;

@SpringBootApplication
public class WineListProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(WineListProjectApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WineListProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner wineDemo(WineRepository wrepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a wine");
			
			// Creating categories
			crepository.save(new Category("red"));
			crepository.save(new Category("white"));
			crepository.save(new Category("sparkling"));
			crepository.save(new Category("rose"));
			
			// Creating a wine
			wrepository.save(new Wine("Chateau Musar", "France, Cabernet Sauvignon", 2011, 23.95, 14.0, crepository.findByName("red").get(0), "hyvää"));
						
			// Creating users: admin/admin user/user1
			User user1 = new User("user", "$2a$10$3tS39Zge9aUtub4IL3PYN.MsBxIYNyPqXGtSv1seYW3.48UdCLyfm", "user@haaga-helia.fi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@haaga-helia.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all wines");
			for (Wine wine : wrepository.findAll()) {
				log.info(wine.toString());
			}

		};
	}
}
