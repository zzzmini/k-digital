package com.ex.OXQuiz.repository;

import com.ex.OXQuiz.dto.MemberDTO;
import com.ex.OXQuiz.entity.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM member WHERE member_id LIKE %:memberId%", nativeQuery = true)
    Optional<Member> findByMemberId(@Param("memberId") String memberId);

    @Query(value = "SELECT * FROM member WHERE member_id NOT LIKE '%root%'", nativeQuery = true)
    List<Member> findAllUsers();
//
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE member m SET m.status = TRUE WHERE m.id = :id", nativeQuery = true)
//    void changeUserStatus(@Param("id") Long id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE member m SET m.status = FALSE WHERE m.id = :id", nativeQuery = true)
//    void deleteUser(@Param("id") Long id);

}
