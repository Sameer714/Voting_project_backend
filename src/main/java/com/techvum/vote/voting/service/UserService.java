package com.techvum.vote.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.helpers.PasswordChecker;
import com.example.vote.duplicate.DuplicateUsernameException;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User saveUser(User user) throws DuplicateUsernameException{
		User isUserPresent = userRepo.findByEmail(user.getEmail());
		if (isUserPresent== null) {
			User u = new User();
			
			u.setEmail(user.getEmail());
			u.setRole("ROLE_" + user.getRole());
			u.setName(user.getName());
			u.setUsername(user.getUsername());
			
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				u.setStatus("INACTIVE");
			} else {
				u.setStatus("ACTIVE");
			}
			
			if (user.getPass().isEmpty()) {
				throw new DuplicateUsernameException("Enter Password!", "Invalid : ");

			} else {
				PasswordChecker passwordChecker = new PasswordChecker();
				if (passwordChecker.isValid(user.getPass())) {
					u.setPass(user.getPass());
					return userRepo.save(u);
				} else {
					throw new DuplicateUsernameException("Password doesn't follow our criteria!", "Invalid : ");
				}	
		}
	}
		throw new DuplicateUsernameException("Email id Already Registered!", "Duplicate :");
}

	public User updateUser(User user, long id)  throws DuplicateUsernameException {
		User u = userRepo.findById(id);
		u.setName(user.getName());
		User isUserPresent = userRepo.findByEmail(user.getEmail());
		if (isUserPresent != null) {
			User isusrnmPresent = userRepo.findByUsername(user.getUsername());
			if (isusrnmPresent == null) {
				u.setUsername(user.getUsername());
			} else {
				u.setUsername(u.getUsername());
			}
			u.setEmail(user.getEmail());
			u.setRole("ROLE_" + user.getRole());
			if (!user.getPassword().isEmpty()) {
				PasswordChecker passwordChecker = new PasswordChecker();
				if (passwordChecker.isValid(user.getPassword())) {
					u.setPass(user.getPassword());
					return userRepo.save(u);
				} else {
					u.setPass(u.getPassword());
					return userRepo.save(u);

				}
			}
		}
		throw new DuplicateUsernameException("Email Not Registered!", "Not Found:");
		
	}

	public List<User> getAllUserToApprove() {
		return userRepo.findAllByStatusAndRole("INACTIVE","ROLE_ADMIN");
	}

	public ResponseEntity<String> updateStatus(long id) {
		User user = userRepo.findById(id);
		if(user.getStatus().equalsIgnoreCase("INACTIVE")) {
			user.setStatus("ACTIVE");
			userRepo.save(user);
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + "Updated Successfully" + "\" ,  \"Success\": \"" + "true" + "\"}");
		}
		else {
			user.setStatus("INACTIVE");
			userRepo.save(user);
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"" + "Updated Successfully" + "\" ,  \"Success\": \"" + "true" + "\"}");
		}
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();	}
}