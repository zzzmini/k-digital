package com.my.membership.repository;

import com.my.membership.dto.Member;
import org.springframework.util.ObjectUtils;

import java.util.*;

public class MemberRepositoryImpl implements MemberRepository{
    // 회원정보 저장소
    public static Map<Long, Member> store = new HashMap<>();
    // 회원아이디를 관리
    private static Long sequence = 1L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(x -> x.getName().equals(name))
                .findAny();  // findAny : 있으면 찾아주고 없으면 Null 담는 아이
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Long deleteById(Long id) {
        Member member = store.remove(id);
        if(ObjectUtils.isEmpty(member)){
            return 0L;
        } else {
            return 1L;
        }
    }

    @Override
    public Long updateById(Long id, Member member) {
        Member result = store.put(id, member);
        if(ObjectUtils.isEmpty(result)){
            return 0L;
        } else {
            return 1L;
        }
    }

    public void clearStore() {
        store.clear();
        sequence = 1L;
    }
}
