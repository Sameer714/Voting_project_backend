package com.techvum.vote.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.helpers.PasswordChecker;
import com.example.login.duplicate.DuplicateUsernameException;
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
}