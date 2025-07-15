package service;

import repository.MemberRepository;
import vo.Member;

import java.util.Map;

public class MemberServiceImpl implements Service{
    @Override
    public void addStore(Member member) {
        System.out.println("추가 서비스");

        // 비어있는 키 값 할당하기
        int id = MemberRepository.key;
        member.setId(id);

        // 키 값 증가 시키기
        MemberRepository.key++;

        // 맵에 저장하기
        MemberRepository.store.put(id, member);
    }

    @Override
    public Member findById(int id) {
        System.out.println("멤버 1개 검색 서비스");
        return null;
    }

    @Override
    public Map<Integer, Member> findAll() {
        System.out.println("전체 출력 서비스");
        // store를 통째로 넘겨준다.
        return MemberRepository.store;
    }

    @Override
    public boolean updateStore(int id, Member member) {
        System.out.println("수정 서비스");
        return false;
    }

    @Override
    public boolean removeStore(int id) {
        System.out.println("삭제 서비스");
        return false;
    }
}
