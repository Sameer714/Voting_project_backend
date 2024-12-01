package com.techvum.vote.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techvum.vote.voting.model.Query;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.model.Vote;

public interface VoteRepo extends JpaRepository<Vote, Long> {
    Vote findByQueryAndUser(Query query, User user);
}