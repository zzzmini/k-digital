package service;

import vo.Member;

import java.util.Map;

public class MemberServiceImpl implements Service{
    @Override
    public void addStore(Member member) {
        System.out.println("추가 서비스");
    }

    @Override
    public Member findById(int id) {
        System.out.println("멤버 1개 검색 서비스");
        return null;
    }

    @Override
    public Map<Integer, Member> findAll() {
        System.out.println("전체 검색 서비스");
        return Map.of();
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
