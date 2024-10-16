package com.techvum.vote.voting.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techvum.vote.voting.model.GlobalInput.Query;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.model.Vote;

public interface VoteRepo extends JpaRepository<Vote, Long> {
    Optional<Vote> findByQueryAndUser(Query query, User user);
}