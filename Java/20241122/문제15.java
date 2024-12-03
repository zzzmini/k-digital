package basic.exam;

import java.util.Scanner;

public class 문제15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while (true) {
            System.out.println("======================");
            System.out.println("메뉴를 선택하세요");
            System.out.println("1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
            System.out.println("======================");
            System.out.println("메뉴를 선택하세요(1~4)");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("안녕하세요");
                    break;
                case 2:
                    System.out.println("삐끼삐끼 춤입니다.");
                    break;
                case 3:
                    System.out.println("맛나게 먹었습니다.");
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘 못 입력했습니다.");
            }
        }
    }
}
