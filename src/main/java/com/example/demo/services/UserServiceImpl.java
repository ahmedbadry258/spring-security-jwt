package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service 
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  RoleRepository roleRepository;

	@Override
	public User saveUser(User user) {
	log.info("save user {}",user.getUsername());
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("save role {}",role.getName());
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("add role {} to user {}",roleName,username);
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		log.info("get User {}",username);
		return  userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("find All Users");
		return userRepository.findAll();
	}

}
