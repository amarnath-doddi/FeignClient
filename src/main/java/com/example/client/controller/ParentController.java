package com.example.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.exception.InvalidCredentialsException;
import com.example.client.feign.LoginService;
import com.example.client.feign.UserService;
import com.example.client.model.User;

@RestController
@RequestMapping("/parent")
public class ParentController {
	@Autowired
	private UserService userRegistrationService;
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers(){
		return userRegistrationService.getUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		return userRegistrationService.getUser(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return userRegistrationService.createUser(user);
	}
	
	@PutMapping("/")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return userRegistrationService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
		return userRegistrationService.deleteUser(id);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam String loginId,@RequestParam String password)   throws InvalidCredentialsException{
		return loginService.login(loginId, password);
	}
}
