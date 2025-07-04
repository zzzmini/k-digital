import java.util.Scanner;

public class MegaCoffeeManager {
    // 공통스캐너 만들기
    public static Scanner sc = new Scanner(System.in);
    // 전체에서 사용할 메뉴의 크기를 갖는 상수
    public static final int MENU_COUNT = 5;
    // 전체에서 사용할 배열을 스태틱으로 선언하기
    static String[] products = new String[MENU_COUNT];
    static int[] price = new int[MENU_COUNT];
    // sales : 메뉴별 판매금액
    static int[] sales = new int[MENU_COUNT];

    public static void main(String[] args) {
        // 데이터 초기화 작업
        dataInitialize();

        // 메인메뉴를 보여주는 함수
        mainMenu();
    }

    private static void dataInitialize() {
        // 메뉴 초기화 작업
        // 길이 5인 배열을 선언
        // products : 메뉴이름
        products[0] = "아메리카노";
        products[1] = "아이스아메리카노";
        products[2] = "메가리카노";
        // price : 메뉴별 가격

        price[0] = 1800;
        price[1] = 2000;
        price[2] = 3000;
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
        // 비밀번호 확인
        while (true) {
            System.out.println("관리자 화면");
            System.out.println("1. 메뉴 가격 수정하기  2. 메뉴 추가하기  3. 정산하기  4. 돌아가기");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menuUpdate();
                    break;
                case 2:
                    menuInsert();
                    break;
                case 3:
                    adminResult();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘 못 입력 했어요");
            }
        }
    }

    private static void adminResult() {
        System.out.println("정산하기 화면");
    }

    private static void menuInsert() {
        System.out.println("메뉴 추가하기 화면");
    }

    private static void menuUpdate() {
        System.out.println("메뉴 가격 수정화면");
    }

    // 사용자 메뉴 보이기
    private static void order() {
        while (true) {
            System.out.println("메가 커피 메뉴");
            // 배열을 읽어서 메뉴와 가격을 출력
            for (int i = 0; i < MENU_COUNT; i++) {
                if (products[i] != null) {
                    String strMenu = (i+1) + " / " + products[i] + " / " + price[i];
                    System.out.println(strMenu);
                }
            }

            System.out.println("0. 돌아가기");
            System.out.println("주문할 번호를 입력하세요");
            int orderNumber = sc.nextInt();

            if (orderNumber == 0) {
                System.out.println("메인으로 돌아갑니다.");
                return;
            }
            if (orderNumber >= 1 && orderNumber <= 5) {
                // 선택한 메뉴 처리
                // 메뉴에 있는 번호인지, 없는 번호인지 체크
                if (products[orderNumber - 1] != null) {
                    System.out.println("주문이 완료되었습니다.");
                    System.out.println(products[orderNumber - 1] + " 받아가세요");
                    // 판매 금액을 처리한 후 메인 메뉴로 돌아가야 함.
                    sales[orderNumber - 1] = sales[orderNumber - 1] + price[orderNumber - 1];
                    System.out.println("누적판매금액 : " + sales[orderNumber - 1]);
                    return;
                } else {
                    System.out.println("해당 번호의 제품은 없습니다.");
                    continue;
                }
            } else {
                System.out.println("잘못입력했어요,");
                continue;
            }
        }
    }
}
