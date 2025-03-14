package com.my.membership.repository;

import com.my.membership.dto.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);
    List<Member> findAll();

    // 삭제
    Long deleteById(Long id);

    // 수정
    Long updateById(Long id, Member member);
}
