package com.techvum.vote.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techvum.vote.voting.helpers.JwtHelper;
import com.techvum.vote.voting.model.GlobalInput;
import com.techvum.vote.voting.model.GlobalInput.JwtResponse;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.repo.UserRepo;

@RestController 
public class AuthController {
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private JwtHelper jwtHelper;
    
    @PostMapping("/login")
    public ResponseEntity<GlobalInput.JwtResponse> login(@RequestBody GlobalInput.JwtRequest request) {
        JwtResponse response = new JwtResponse();
        
        User user = userRepo.findByEmail(request.getEmail());
        
        if (user != null) {
            if (!user.getStatus().equalsIgnoreCase("ACTIVE")) {
                response.setUsername("USER INACTIVE!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            if (user.getPass().equals(request.getPass())) {
                String token = jwtHelper.generateToken(user);

                response.setJwtoken(token);
                response.setUsername(user.getUsername());
                response.setRole(user.getRole());
                response.setId(user.getId());

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setUsername("Invalid Credentials!");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } else {
            response.setUsername("User not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
