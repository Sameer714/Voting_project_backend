package com.techvum.vote.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvum.vote.voting.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);


}
