package com.ex.basicCRUD.repository;

import com.ex.basicCRUD.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository
        extends JpaRepository<Member, Long> {
}
