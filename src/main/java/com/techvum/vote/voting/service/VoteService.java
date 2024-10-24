package com.techvum.vote.voting.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.model.GlobalInput;
import com.techvum.vote.voting.model.Query;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.model.Vote;
import com.techvum.vote.voting.repo.QueryRepo;
import com.techvum.vote.voting.repo.UserRepo;
import com.techvum.vote.voting.repo.VoteRepo;

@Service
public class VoteService {

    @Autowired
    private VoteRepo voteRepo;

    @Autowired
    private QueryRepo queryRepo;

    @Autowired
    private UserRepo userRepo;

    public Vote castVote(GlobalInput.VoteRequest voteRequest) {
        // Get the Query object or throw an exception if not found
        Query query = queryRepo.findById(voteRequest.getQueryId())
                .orElseThrow(() -> new RuntimeException("Query not found"));

        // Get the User object or throw an exception if not found
        User user = userRepo.findById(voteRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the user has already voted on this query
        Optional<Vote> existingVote = voteRepo.findByQueryAndUser(query, user);
        if (existingVote.isPresent()) {
            throw new RuntimeException("User has already voted on this query");
        }

        // Create and save the new Vote object
        Vote vote = new Vote();
        vote.setQuery(query);
        vote.setUser(user);
        vote.setSelectedOption(voteRequest.getSelectedOption());
        vote.setTimestamp(LocalDateTime.now());

        return voteRepo.save(vote);
    }
}
