package com.techvum.vote.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techvum.vote.voting.model.GlobalInput;
import com.techvum.vote.voting.model.Vote;
import com.techvum.vote.voting.service.VoteService;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote> castVote(GlobalInput.VoteRequest voteRequest) {
        Vote vote = voteService.castVote(voteRequest);
        return ResponseEntity.ok(vote);
    }
}