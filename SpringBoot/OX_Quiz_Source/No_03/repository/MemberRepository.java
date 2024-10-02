package com.example.oxquizproject.repository;

import com.example.oxquizproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM member ORDER BY id", nativeQuery = true)
    List<Member> searchAll();

    boolean existsByIdAndPassword(String id, String password);

    //쿼리메서드 - JPA에서 제공하는 기능
    Optional<Member> findById(String id);

}
