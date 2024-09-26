package com.my.membership.service;

import com.my.membership.dto.Member;
import com.my.membership.repository.MemberRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MemberServiceTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();
    MemberService service = new MemberService(repository);

    @AfterEach
    void after() {
        repository.clearStore();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void 회원가입() {
        // Given
        Member member = new Member();
        member.setName("김형민");
        // When
        Long savedId = service.join(member);
        // Then
        Member findMember = service.findOne(savedId).get();
        assertThat(member.getName())
                .isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외() {
        //Given
        Member kim = new Member();
        kim.setName("김형민");

        Member kim2 = new Member();
        kim2.setName("김형민");
        //When
        service.join(kim);
        Long result = service.join(kim2);
        //Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    void 전체멤버검색() {
        // Given
        Member jang = new Member();
        jang.setName("장원영");
        service.join(jang);
        Member ahn = new Member();
        jang.setName("안유진");
        service.join(ahn);
        // When
        List<Member> members = service.findMember();
        // Then
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    void 아이디로검색하기() {
        // Given
        Member member = new Member();
        member.setName("장원영");
        service.join(member);
        // When
        Long id = 1L;
        Optional<Member> result = service.findOne(id);
        // Then
        assertThat(result.get().getName())
                .isEqualTo("장원영");
    }
}