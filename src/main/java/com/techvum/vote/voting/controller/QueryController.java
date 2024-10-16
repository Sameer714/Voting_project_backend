package com.techvum.vote.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techvum.vote.voting.model.GlobalInput.Query;
import com.techvum.vote.voting.service.QueryService;

import java.util.List;

@RestController
@RequestMapping("/api/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping
    public ResponseEntity<Query> createQuery(@RequestBody Query query) {
        Query createdQuery = queryService.createQuery(query);
        return ResponseEntity.ok(createdQuery);
    }

    @GetMapping
    public ResponseEntity<List<Query>> getAllQueries() {
        List<Query> queries = queryService.getAllQueries();
        return ResponseEntity.ok(queries);
    }
}