package com.techvum.vote.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techvum.vote.voting.model.GlobalInput.Query;
import com.techvum.vote.voting.repo.QueryRepo;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepo queryRepo;

    public Query createQuery(Query query) {
        return queryRepo.save(query);
    }

    public List<Query> getAllQueries() {
        return queryRepo.findAll();
    }
}
