package com.techvum.vote.voting.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvum.vote.voting.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByStatus(String status);
    List<User> findAll();

    User findById(long id);
    User findByUsername(String username); 
    User findByEmail(String email); 
    List<User> findAllByStatusAndRole(String status, String role);
}