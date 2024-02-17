package com.nexus.repository;

import com.nexus.models.Reels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReelsRepository extends JpaRepository<Reels, Integer> {
    public List<Reels> findByUserId(Integer userId);
}
