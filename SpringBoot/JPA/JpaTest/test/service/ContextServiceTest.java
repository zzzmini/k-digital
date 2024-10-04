package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContextServiceTest {
    @Autowired
    EntityManager em;

    @Autowired
    ContextService contextService;

    @Test
    @DisplayName("1차 캐시 테스트")
    public void firstCash() {
        Member member = contextService.memberInsert();
        System.out.println("====== " + member);
    }

    @Test
    @DisplayName("데이터 영속성 보장 테스트")
    void persistContextText() {
        Member a = em.find(Member.class, "jang");
        Member b = em.find(Member.class, "jang");
        System.out.println("===== " + a.equals(b));
    }

    @Test
    @DisplayName("Transaction Commit 테스트")
    void transactionCommitTest() {
        contextService.transactionTest();
    }

    @Test
    @DisplayName("Dirty Checking 테스트")
    void dirtyCheckingTest() {
        contextService.dirtyCheckingTest();
    }

    @Test
    @DisplayName("Delete 테스트")
    void deleteTest() {
        contextService.deleteMemberTest();
    }
}