import java.util.Scanner;

public class VendingMachineMain {
    // 전체적으로 자주 사용하는 변수와 배열을 선언
    static Scanner sc = new Scanner(System.in);
    // 전체 제품 수
    static final int COUNT = 5;
    // 배열을 선언
    // 제품명, 가격, 재고, 판매금액
    static String[] product = new String[COUNT]; // 제품명
    static int[] price = new int[COUNT];  // 단가
    static int[] stock = new int[COUNT]; // 재고 수량
    static int[] sales = new int[COUNT]; // 판매금액

    static void dataInitialize() {
        product[0] = "coke";
        price[0] = 500;
        stock[0] = 3;

        product[1] = "cyder";
        price[1] = 700;
        stock[1] = 3;

        product[2] = "coffee";
        price[2] = 1500;
        stock[2] = 3;
    }

    public static void main(String[] args) {
        // 데이터 초기화 함수 호출하기
        dataInitialize();
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {

            // 판매정보 얻어오기
            getInfo();

            System.out.println("돈을 넣어주세요:");
            int choice = sc.nextInt();
            // 1004 인 경우 관리자 메뉴로 갑니다.
            if (choice == 1004) {
                admin();
            } else {
                userMenu();
            } 
        }
    }

    private static void getInfo() {
        System.out.println("========================================");
        System.out.println("자판기입니다.(번호:상품(가격)-재고)");

        //System.out.println("1:제품1(100W)-1개 2:제품2(100W)-1개 3:제품3(100W)-1개");
        System.out.println("========================================");
    }

    private static void userMenu() {
        System.out.println("사용자 페이지");
    }

    private static void admin() {
        while (true) {
            System.out.println("관리자 페이지입니다.");
            System.out.println("1:메뉴변경 2:가격변경 3:재고추가 4:메뉴추가 5:수익확인(종료는 -1)");
            System.out.println("번호를 입력하세요:");
            int choice = sc.nextInt();
            // 입력한 번호에 따라서 분기
            switch (choice) {
                case -1:  // 종료
                    System.out.println("메인으로 돌아가요.");
                    return;
                case 1:  // 메뉴변경
                    updateMenu();
                    break;
                case 2:  // 가격변경
                    updatePrice();
                    break;
                case 3:  // 재고추가
                    updateStock();
                    break;
                case 4:  // 메뉴추가
                    addMenu();
                    break;
                case 5:  // 수익확인
                    salesConfirm();
                    break;
                default:
                    System.out.println("잘 못 입력했어요");
                    continue;
            }
        }
    }

    private static void salesConfirm() {
        // 매출확인
        System.out.println("매출확인 페이지");
    }

    private static void addMenu() {
        // 메뉴 추가
        System.out.println("메뉴 추가 페이지");
    }

    private static void updateStock() {
        // 재고 수정
        System.out.println("재고 수정 페이지");
    }

    private static void updatePrice() {
        // 가격 수정
        System.out.println("가격 수정 페이지");
    }

    private static void updateMenu() {
        // 메뉴 수정
        System.out.println("메뉴 수정 페이지");
    }
}
