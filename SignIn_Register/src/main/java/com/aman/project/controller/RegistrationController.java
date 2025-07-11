package com.aman.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aman.project.model.MyAppUser;
import com.aman.project.repository.MyAppUserRepository;

@RestController
public class RegistrationController {
	
	@Autowired
	MyAppUserRepository myAppUserRepositor;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping(value = "/req/signup", consumes = "application/json")
	public MyAppUser createUser(@RequestBody MyAppUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return myAppUserRepositor.save(user);
	}

}
