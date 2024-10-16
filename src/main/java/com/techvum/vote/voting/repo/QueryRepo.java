package com.techvum.vote.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techvum.vote.voting.model.GlobalInput.Query;

public interface QueryRepo extends JpaRepository<Query, Long>{
}