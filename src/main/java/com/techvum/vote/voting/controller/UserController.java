package com.techvum.vote.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.duplicate.DuplicateUsernameException;
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
	
	@PutMapping("/Updateuser/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable long id)
			throws DuplicateUsernameException {
		try {
			User saveUser = userService.updateUser(user, id);
			if (saveUser != null) {
				if (saveUser.getRole().equals("ROLE_ADMIN")) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("{\"message\": \"" + "User Created Successfully , Wait for Admin Approval!"
									+ "\" ,  \"Success\": \"" + "true" + "\"}");
				} else if (saveUser.getRole().equals("ROLE_USER")) {
					return ResponseEntity.status(HttpStatus.OK).body(
							"{\"message\": \"" + "User Saved Successfully" + "\" ,  \"Success\": \"" + "true" + "\"}");
				}
			}
		} catch (DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{\"message\": \"" + e.getMessage() + "\" , \"Success\": \"" + "false" + "\"}");
		}
		return null;
	}

	@GetMapping("/getAllUserToApprove")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> getAllUserToApprove() {
		return userService.getAllUserToApprove();
	}

	@PutMapping("/updateStatus/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> updateStatus(@PathVariable long id) throws DuplicateUsernameException{
		return userService.updateStatus(id);
	}
}