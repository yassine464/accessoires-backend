package com.yassine.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.users.entities.Role;
import com.yassine.users.entities.User;
import com.yassine.users.service.UserService;

@SpringBootApplication
public class UsersMicroserviceApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}

	// Ajoute les rôles et les utilisateurs au premier démarrage seulement
	@Override
	public void run(String... args) throws Exception {
		if (userService.findUserByUsername("admin") == null) {
			// ajouter les rôles
			userService.addRole(new Role(null, "ADMIN"));
			userService.addRole(new Role(null, "USER"));

			// ajouter les users
			userService.saveUser(new User(null, "admin", "123", true, new ArrayList<>()));
			userService.saveUser(new User(null, "yassine", "123", true, new ArrayList<>()));

			// ajouter les rôles aux users
			userService.addRoleToUser("admin", "ADMIN");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("yassine", "USER");
		}
	}
}
