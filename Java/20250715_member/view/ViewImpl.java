package view;

import service.MemberServiceImpl;
import service.Service;
import vo.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ViewImpl implements ViewInterface{
    private Scanner sc = new Scanner(System.in);
    // 멤버 서비스 생성하기
    Service memberService = new MemberServiceImpl();

    @Override
    public void addView() {
        System.out.println("멤버 추가 화면");
        System.out.println("이름 : ");
        String name = sc.next();
        System.out.println("나이 : ");
        int age = sc.nextInt();

        // 빈 깡통 멤버 생성 후 이름, 나이 할당
        Member member = new Member();
        member.setName(name);
        member.setAge(age);

        // 멤버서비스의 addStore로 멤버를 실어서 보냄
        memberService.addStore(member);
        System.out.println("정상적으로 추가 되었습니다.");
    }

    @Override
    public void updateView() {
        System.out.println("멤버 수정 화면");
    }

    @Override
    public void removeView() {
        System.out.println("멤버 삭제 화면");
    }

    @Override
    public void ListView() {
        // 전체 데이터를 받을 맵을 선언
        Map<Integer, Member> lists = new HashMap<>();
        System.out.println("멤버 리스트보기 화면");

        // 전체 멤버 데이터(맵) 받아오기
        lists = memberService.findAll();

        // 전체 데이터가 비어있는지 확인
        if (lists.size() == 0) {
            System.out.println("자료가 없습니다.");
            return;
        } else {
            title();

            // 출력하기
            for (Integer x : lists.keySet()) {
                System.out.println(lists.get(x));
            }
            line();
        }
    }

    private void title() {
        line();
        System.out.println("ID  Name   age");
        line();
    }

    private void line() {
        System.out.println("===============");
    }
}
