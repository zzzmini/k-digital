package com.my.membership.service;

import com.my.membership.dto.Member;
import com.my.membership.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    // MemberRepsotoryImpl 여기서 정의한 메서드를 이용
//    MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();
    // 1. 어노테이션을 이용하는 방법
//    @Autowired
//    MemberRepositoryImpl repository;
    // 2. 생성자를 이용한 주입방법
//    private final MemberRepositoryImpl repository;
//
//    public MemberService(MemberRepositoryImpl repository) {
//        this.repository = repository;
//    }
    // 3. 클래스 선언부 @RequiredArgsConstructor 를 사용하고 final 사용하는 방법
    private final MemberRepositoryImpl repository;
    // 전체 조회
    public List<Member> findMember() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    }

    // 회원가입
    public Long join(Member member) {
        // 중복회원가입 불가능
        Optional<Member> findMember =
                repository.findByName(member.getName());
        if (ObjectUtils.isEmpty(findMember)) {
            repository.save(member);
            return member.getId();
        } else {
            return 0L;
        }
    }

    // 수정
    public Long update(Long id, Member member) {
        return repository.updateById(id, member);
    }

    // 삭제
    public Long delete(Long id) {
        return repository.deleteById(id);
    }
}
