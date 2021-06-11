package com.example.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.client.model.User;

@FeignClient(url = "http://localhost:9011/api/users", value = "userRegistrationService")
public interface UserService {
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers();
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id);
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user);
	
	@PutMapping("/")
	public ResponseEntity<User> updateUser(@RequestBody User user);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id);
	
	
	
	
}
