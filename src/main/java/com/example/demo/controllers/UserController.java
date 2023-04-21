package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImpl;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserServiceImpl userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toString());
		return ResponseEntity.ok().body(userService.saveUser(user));
	}

	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toString());
		return ResponseEntity.ok().body(userService.saveRole(role));
	}

	@PostMapping("/role/addtouser")
	public ResponseEntity<Role> saveRole(@RequestBody RoleToUserForm form) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toString());
		userService.addRoleToUser(form.getUsername(),form.getRoleName());
		return ResponseEntity.ok().build();
	}


}
@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}
