package com.my.membership.repository;

import com.my.membership.dto.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();

    // 각 테스트 종료 후 맵을 청소
    @AfterEach
    public void after() {
        repository.clearStore();
    }

    // Map에 저장이 잘 되는지 테스트
    @Test
    @DisplayName("저장하기 테스트")
    void save() {
        // Given
        Member jang = new Member();
        jang.setName("장원영");
        // When
        Member result = repository.save(jang);
        // Then
//        Assertions.assertEquals("TEST","Test");
        // JUNIT 사용
        Assertions.assertEquals(jang.getName(),result.getName());
        // AssertJ
        assertThat(jang.getName()).isEqualTo(result.getName());
    }

    @Test
    @DisplayName("아이디로 검색하기 테스트")
    void findById() {
        // Given
        Member member = new Member();
        member.setName("안유진");
        repository.save(member);
        // When
        // 1번 아이디의 이름이 안유진임을 확인
        Long id = 1L;
        Member result = repository.findById(id).orElse(null);
        // Then
        assertThat(result.getName()).isEqualTo("안유진");
    }

    @Test
    @DisplayName("이름으로 검색하기 테스트")
    void findByName() {
        // Given
        Member kim = new Member();
        kim.setName("김형민");
        repository.save(kim);

        Member hong = new Member();
        hong.setName("홍길동");
        repository.save(hong);
        // When
        Member result = repository.findByName("홍길동").orElse(null);
        Member result2 = repository.findByName("장원영").orElse(null);
        // Then
        // 찾았을 경우
        assertThat(result).isEqualTo(hong);
        // 못찾았을 경우
        assertThat(result2).isEqualTo(null);
    }

    @Test
    @DisplayName("전체 검색하기")
    void findAll() {
        // Given
        Member kim = new Member();
        kim.setName("김형민");
        repository.save(kim);

        Member hong = new Member();
        hong.setName("홍길동");
        repository.save(hong);
        // When
        List<Member> members = repository.findAll();
        // Then
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    void 삭제테스트() {
        // Given
        Member member = new Member();
        member.setName("장원영");
        repository.save(member);
        // When
        Long deleteId = 1L;
        repository.deleteById(deleteId);
        // Then
        Member result = repository.findById(deleteId).orElse(null);
        assertThat(result).isEqualTo(null);
    }
    @Test
    void 수정테스트() {
        // Given
        Member member = new Member();
        member.setName("장원영");
        repository.save(member);
        // When(1번 아이디 수정)
        Member updateMember = new Member();
        updateMember.setId(1L);
        updateMember.setName("안유진");
        repository.updateById(1L, updateMember);
        // Then
        Member result = repository.findById(1L).orElse(null);
        assertThat(result.getName()).isEqualTo("안유진");
    }
}