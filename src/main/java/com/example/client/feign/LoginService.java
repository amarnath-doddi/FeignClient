package com.example.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.client.exception.InvalidCredentialsException;

@FeignClient(url="http://localhost:9010/api/users", value = "loginService")
public interface LoginService {
	@GetMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam String loginId,@RequestParam String password)  throws InvalidCredentialsException;
	
	

}
