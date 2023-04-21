package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

	@Autowired
	private UserServiceImpl userService;
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	


}

	@Override
	public void run(String... args) throws Exception {
		userService.saveRole(new Role(null,"ROLE_USER"));
		userService.saveRole(new Role(null,"ROLE_MANAGER"));
		userService.saveRole(new Role(null,"ROLE_ADMIN"));
		userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
		
		userService.saveUser(new User(null,"Ahmed Badry","ahmed","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"mona Ali","mona","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"ali mohamed","ali","1234",new ArrayList<>()));
		userService.saveUser(new User(null,"aml ahmed","aml","1234",new ArrayList<>()));
		
		userService.addRoleToUser("ahmed", "ROLE_USER");
		userService.addRoleToUser("ahmed", "ROLE_MANAGER");
		userService.addRoleToUser("mona", "ROLE_MANAGER");
		userService.addRoleToUser("ali", "ROLE_ADMIN");
		userService.addRoleToUser("aml", "ROLE_SUPER_ADMIN");
		System.out.println("added");
	}
}