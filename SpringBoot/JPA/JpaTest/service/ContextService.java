package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContextService {
    @Autowired
    EntityManager em;

    public Member memberInsert() {
        Member member = new Member();
        member.setMember_id("jang");
        member.setName("장원영");
        em.persist(member);

        Member findMember = em.find(Member.class, "jang");
        return findMember;
    }

    public void transactionTest() {
        Member ahn = new Member();
        ahn.setMember_id("ahn");
        ahn.setName("안유진");

        Member kim = new Member();
        kim.setMember_id("kim");
        kim.setName("김형민");

        em.persist(ahn);
        em.persist(kim);
        em.flush();
    }

    @Transactional
    public void dirtyCheckingTest() {
        // 엔티티 조회
        Member kim = em.find(Member.class, "kim");
        // 영속 엔티티 수정
        kim.setName("hi~~~");
    }

    public void deleteMemberTest() {
        // 삭제할 데이터 검색
        Member member = em.find(Member.class, "kim");
        em.remove(member);
    }
}
