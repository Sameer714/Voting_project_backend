package com.techvum.vote.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.duplicate.DuplicateUsernameException;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.service.UserService;


@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/createuser", produces = "application/json")
	public ResponseEntity<Object> saveUser (@RequestBody User user) throws DuplicateUsernameException{
		try {
			User entryUser = userService.saveUser(user);
			if (entryUser != null) {
				if (entryUser.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("{\"message\": \"" + "User Saved Successfully , Wait for Admin Approval!"
									+ "\" ,  \"Success\": \"" + "true" + "\"}");
				} else if (entryUser.getRole().equalsIgnoreCase("ROLE_USER")) {
					return ResponseEntity.status(HttpStatus.OK).body(
							"{\"message\": \"" + "User Saved Successfully" + "\" ,  \"Success\": \"" + "true" + "\"}");
				}
			}
		} 
		catch (DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
		}
		return null;
	}
}
