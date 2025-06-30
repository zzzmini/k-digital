package ch02;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        // 버스요금
        // 청소년 : 900원
        // 성인 : 1300원
        // 고령층 : 무료
        // 나머지 : 잘못 입력했습니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("당신의 상태를 입력하세요.");
        System.out.println("청소년/성인/고령층");
        String status = sc.next();
        if (status.equals("청소년")) {
            System.out.println("900원");
        } else if (status.equals("성인")) {
            System.out.println("1300원");
        } else if (status.equals("고령층")) {
            System.out.println("무료");
        } else {
            System.out.println("잘 못 입력했습니다.");
        }

        // switch 구문
        switch (status) {
            case "청소년" :
                System.out.println("900원");
                break;
            case "성인":
                System.out.println("1300원");
                break;
            case "고령층":
                System.out.println("무료");
                break;
            default:
                System.out.println("잘 못 입력했어요");
        }

        // 범위는 스위치 구문으로 불가하다.
    }
}
