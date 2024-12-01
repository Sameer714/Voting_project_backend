package com.techvum.vote.voting.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.model.Query;
import com.techvum.vote.voting.model.User;
import com.techvum.vote.voting.model.Vote;
import com.techvum.vote.voting.model.VoteRequest;
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

    public ResponseEntity<Object> castVote(VoteRequest voteRequest) {
        Map<String, Object> response = new HashMap<>();
        
        Query query = queryRepo.findById(voteRequest.getQueryId()).orElse(null);
        if (query == null) {
            response.put("message", "Query not found");
            response.put("Success", "false");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }


        User user = userRepo.findById(voteRequest.getUserId());
        if (user == null) {
            response.put("message", "User not found");
            response.put("Success", "false");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        Vote existingVote = voteRepo.findByQueryAndUser(query, user);
        if (existingVote != null) {
            response.put("message", "User has already voted on this query");
            response.put("Success", "false");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        
        Vote vote = new Vote();
        vote.setQuery(query);
        vote.setUser(user);
        vote.setSelectedOption(voteRequest.getSelectedOption());
        vote.setTimestamp(LocalDateTime.now());

        voteRepo.save(vote);

        response.put("message", "Vote cast successfully");
        response.put("Success", "true");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
