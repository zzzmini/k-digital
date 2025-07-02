package quiz_01;

import java.util.Scanner;

public class Q_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.println("번호를 선택하세요");
            int num = sc.nextInt();
            switch (num) {
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
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("잘 못 입력했어요");
            }
        }
    }

    public static void printMenu() {
        System.out.println("======================");
        System.out.println("메뉴를 선택하세요");
        System.out.println("======================");
        System.out.println("1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
    }
}
