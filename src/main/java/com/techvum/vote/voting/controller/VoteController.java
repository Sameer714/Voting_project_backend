package com.techvum.vote.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techvum.vote.voting.model.VoteRequest;
import com.techvum.vote.voting.service.VoteService;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<ResponseEntity<Object>> castVote(@RequestBody VoteRequest voteRequest) {
        ResponseEntity<Object> vote = voteService.castVote(voteRequest);
        return ResponseEntity.ok(vote);
    }
}