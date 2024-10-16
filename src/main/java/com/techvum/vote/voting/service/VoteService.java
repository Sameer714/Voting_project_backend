package com.techvum.vote.voting.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.model.GlobalInput.Query;
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

    public Vote castVote(Long queryId, Long userId, String selectedOption) {
        Query query = queryRepo.findById(queryId)
                .orElseThrow(() -> new RuntimeException("Query not found"));
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Vote> existingVote = voteRepo.findByQueryAndUser(query, user);
        if (existingVote.isPresent()) {
            throw new RuntimeException("User has already voted on this query");
        }
        Vote vote = new Vote();
        vote.setQuery(query);
        vote.setUser(user);
        vote.setSelectedOption(selectedOption);
        vote.setTimestamp(LocalDateTime.now());

        return voteRepo.save(vote);
    }

}