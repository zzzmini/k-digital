package com.my.jpaTest.repository;

import com.my.jpaTest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends
        JpaRepository<Team, String> {
}
