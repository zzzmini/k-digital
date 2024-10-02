package com.ex.quizCRUD.repository;

import com.ex.quizCRUD.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM member WHERE id = :id", nativeQuery = true)
    Optional<Member> findUserId(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE member SET STATUS = :status, UPDATED_AT = CURDATE() WHERE no = :no", nativeQuery = true)
    void updateStatus(@Param("no")Long no, @Param("status")Boolean status);

    @Transactional
    @Modifying
    @Query(value = "UPDATE member set ANSWER_TRUE = ANSWER_TRUE+1 WHERE ID = :id", nativeQuery = true)
    void rightAnswer(@Param("id")String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE member set ANSWER_FALSE = ANSWER_FALSE+1 WHERE ID = :id", nativeQuery = true)
    void worngAnswer(@Param("id")String id);
}
