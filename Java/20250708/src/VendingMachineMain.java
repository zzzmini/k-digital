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
    // 사용자의 잔액 처리를 위한 전역변수
    static int choice = 0;
    // 처음인지 아닌지 판단하는 플래그
    static int flag = 0;

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

            if (flag == 0) {
                // 프로그램 시작한 후 한번 만 출력
                System.out.println("돈을 넣어주세요:");
                choice = sc.nextInt();
                flag = 1;
            }

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
        String info = "";
        for (int i = 0; i < COUNT; i++) {
            if (product[i] != null) {
                String data = (i+1) + ":" + product[i] + "(" + price[i] + "W)-" + stock[i] + "개 ";
                info = info + data;
            }
        }
        System.out.println(info);
        System.out.println("자판기입니다.(번호:상품(가격)-재고)");

        //System.out.println("1:제품1(100W)-1개 2:제품2(100W)-1개 3:제품3(100W)-1개");
        System.out.println("========================================");
    }

    private static void userMenu() {
        System.out.println("구매할 매뉴의 번호를 입력하세요");
        int num = sc.nextInt();
        // 입금한 돈과  선택한 메뉴의 가격 비교
        // 선택한 제품의 재고가 있는지...
        // 재고도 있고 돈도 충분한 경우
        if (choice >= price[num - 1] && stock[num - 1] > 0) {
            // 판매
            System.out.println(product[num - 1] + "이(가) 나왔다!");
            // 잔액
            choice = choice - price[num - 1];
            System.out.println("잔액 : " + choice);
            // 재고에서 하나 차감 함.
            stock[num - 1]--;

            // 판매 금액 누적하기
            sales[num - 1] = sales[num - 1] + price[num - 1];
        } else if (choice < price[num - 1]) {  // 잔액이 부족한 경우
            System.out.println("잔액이 부족합니다!");
            System.out.println("잔액 : " + choice);
            // 잔액 부족 시 처리할 함수
            userSubMenu();
        }
        System.out.println(num + "을 선택");
    }

    // 잔액 부족 시 처리할 곳
    private static void userSubMenu() {
        System.out.println("1.계속구매하기 2:금액추가하기 3:잔돈반환하기");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                return;
            case 2:
                System.out.println("추가할 금액을 입력하세요");
                int don = sc.nextInt();
                // 1004가 입력되면 관리자 화면으로 이동하기
                if (don == 1004) {
                    admin();
                    return;
                } else {
                    choice = choice + don;
                    return;
                }
            case 3:
                System.out.println("거스름 돈 " + choice + "원이 반환 됩니다.");
                System.out.println("감사합니다. 다음에 또 이용해 주세요!");
                choice = 0;
                return;
            default:
                System.out.println("잘못 누름");
        }
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
        for (int i = 0; i < COUNT; i++) {
            if (product[i] != null) {
                System.out.println(product[i] + " : " + sales[i] + "원");
            }
        }
    }

    private static void addMenu() {
        // 메뉴 추가
        System.out.println("메뉴 추가 페이지");
        // 메뉴를 추가할 수 있는지 확인
        // 추가할 수 있으면 추가할 위치 찾아서 index 넣는다.
        int index = -1;
        for (int i = 0; i < COUNT; i++) {
            if (product[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("더 이상 메뉴를 추가할 수 없어요");
            return;
        }
        // 추가 하기
        System.out.println("추가하실 메뉴의 이름을 입력하세요");
        product[index] = sc.next();
        System.out.println("추가하실 메뉴의 가격을 입력하세요");
        price[index] = sc.nextInt();
        System.out.println("매실차의 재고는 몇 개 입니까?");
        stock[index] = sc.nextInt();
        System.out.println("메뉴 추가가 완료 되었습니다!");
        getInfo();
        return;
    }

    private static void updateStock() {
        // 재고 수정
        System.out.println("재고 수정 페이지");
        // 제품 목록 보여주기
        getInfo();
        System.out.println("재고를 변경하실 메뉴의 번호를 입력하세요");
        int num = sc.nextInt();
        System.out.println(product[num - 1] + "의 재고를 몇 개로 바꾸시겠습니까");
        int change = sc.nextInt();
        System.out.println("재고 수정이 완료 되었습니다!");
        // 가격 변경하기
        stock[num - 1] = change;
        getInfo();
    }

    private static void updatePrice() {
        // 가격 수정
        System.out.println("가격 수정 페이지");
        // 제품 목록 보여주기
        getInfo();
        System.out.println("가격을 변경하실 메뉴의 번호를 입력하세요");
        int num = sc.nextInt();
        System.out.println(product[num - 1] + "의 가격을 얼마로 바꾸시겠습니까");
        int change = sc.nextInt();
        System.out.println("가격 변경이 완료 되었습니다!");
        // 가격 변경하기
        price[num - 1] = change;
        getInfo();
    }

    private static void updateMenu() {
        // 메뉴 수정
        System.out.println("메뉴 수정 페이지");
        // 제품 정보 보여주기
        getInfo();
        System.out.println("변경하실 메뉴의 번호를 입력하세요");
        int num = sc.nextInt();
        System.out.println(product[num - 1] + "를(을) 무엇으로 바꾸시겠습니까?");
        String newProduct = sc.next();
        System.out.println(newProduct + "의 가격은 얼마입니까?");
        int newPrice = sc.nextInt();

        System.out.println(newProduct + "의 재고를 몇 개 등록 하시겠습니까?");
        int newStock = sc.nextInt();
        product[num - 1] = newProduct;
        price[num - 1] = newPrice;
        stock[num - 1] = newStock;

        System.out.println("메뉴 변경이 완료되었습니다!");
        getInfo();
    }
}
