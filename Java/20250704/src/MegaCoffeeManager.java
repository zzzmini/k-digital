import java.util.Scanner;

public class MegaCoffeeManager {
    // 공통스캐너 만들기
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 메인메뉴를 보여주는 함수
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("메가 커피에요.");
            System.out.println("무엇을 도와드릴까요?");
            System.out.println("1. 주문하기  2. 관리자  3. 종료하기");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    order();
                    break;
                case 2:
                    admin();
                    break;
                case 3:
                    // main 함수로 돌아가기
                    return;
                default:
                    System.out.println("잘 못 입력했어요.");
            }
        }
    }

    private static void admin() {

    }

    // 사용자 메뉴 보이기
    private static void order() {
        System.out.println("메가 커피 메뉴");
        System.out.println("1. 아메리카노  1800");
        System.out.println("0. 돌아가기");
        System.out.println("주문할 번호를 입력하세요");
        int orderNumber = sc.nextInt();
        switch (orderNumber) {
            case 1:
                System.out.println("주문이 완료되었습니다.");
                break;
            case 0:
                System.out.println("메인으로 돌아갑니다.");
                return;
            default:
                System.out.println("잘못입력했어요,");
        }
    }
}
