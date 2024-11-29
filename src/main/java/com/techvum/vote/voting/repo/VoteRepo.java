package com.techvum.vote.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.techvum.vote.voting.model.Query;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.model.Vote;

public interface VoteRepo extends JpaRepository<Vote, Long> {
    Optional<Vote> findByQueryAndUser(Query query, User user);
}