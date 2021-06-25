package com.example.cacheservice.repo;

import com.example.cacheservice.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Integer> {
}
