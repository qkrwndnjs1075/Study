package com.example.querydsl.repo;

import com.example.querydsl.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
    Team findByName(String name);
}
