package ch02;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        // ⓐ 좋아하는 그룹 번호를 선택하세요.
        // ⓑ 1. ive 2. 세븐틴 3. 에스파
        // -> 2
        // ⓒ 당신은 세븐틴 광팬입니다.->ⓔ
        // 만약, 없는 번호를 선택하면..
        // ⓓ 잘 못 선택했습니다. -> ⓐ 출력
        // ⓔ 종료하시겠습니까?(Y/N)
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("좋아하는 그룹 번호를 선택하세요.");
            System.out.println("1. ive 2. 세븐틴 3. 에스파");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("당신은 아이브 광팬입니다.");
                    break;
                case 2:
                    System.out.println("당신은 세븐틴 광팬입니다.");
                    break;
                case 3:
                    System.out.println("당신은 에스파 광팬입니다.");
                    break;
                default:
                    System.out.println("잘 못 선택했습니다.");
                    continue;
            }

            System.out.println("종료하시겠어요?(Y/N)");
            String yesOrNo = sc.next();
            // 입력한 값을 대문자로 바꾼다.
            yesOrNo = yesOrNo.toUpperCase();
            System.out.println(yesOrNo);
            if (yesOrNo.equals("Y")) {
                // 프로그램을 종료 시켜야 함.
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (yesOrNo.equals("N")) {
                continue;
            } else {
                System.out.println("잘 못 입력했어요");
                continue;
            }
        }
    }
}














