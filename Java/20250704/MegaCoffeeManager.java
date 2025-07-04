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
                    // 관리자 비밀번호를 체크 : 1004
                    String password = "";
                    System.out.println("관리자 비밀번호를 입력하세요");
                    password = sc.next();
                    if (password.equals("1004")) {
                        admin();
                        continue;
                    } else {
                        System.out.println("비밀번호가 틀립니다.");
                        continue;
                    }
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
                    // 메뉴 가격만 수정
                    menuUpdate();
                    break;
                case 2:
                    // 새로운 메뉴 추가(단, 총 5개까지만...현재 3개 있음)
                    menuInsert();
                    break;
                case 3:
                    // 제품별 총 판매액 출력
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
        // sales 배열에 있는 값들을 출력
        // 맨 아래에 총 판매 금액을 출력
        // 총 판매 누적금액을 저장하는 변수
        int total = 0;
        for (int i = 0; i < MENU_COUNT; i++) {
            if (products[i] != null) {
                String strMenu = (i+1) + " / " + products[i] + " / " + sales[i];
                System.out.println(strMenu);
                total = total + sales[i];
            }
        }
        // 총 판매금액
        System.out.println("-------------------------------------");
        System.out.println("누적 총 판매금액 : " + total);
    }

    private static void menuInsert() {
        // 메뉴 추가 화면
        // 추가 가능한 제품의 갯수 출력해 주기
        int ableCount = 0;
        // 제품 배열을 순회하면서 비어있지 않은 제품 수를 구한다.
        for (int i = 0; i < MENU_COUNT; i++) {
            if (products[i] != null) {
                ableCount++;
            }
        }
        // 전체 배열의 크기에서 뺀다. -> 추가할 수 있는 제품 수
        System.out.println("현재 추가할 수 있는 제품의 수 : " + (MENU_COUNT - ableCount));
        // 추가할 곳이 없으면... 관리자 메뉴로 돌려보낸다.
        if ((MENU_COUNT - ableCount) == 0) {
            System.out.println("관리자 메뉴로 가요..");
            return;
        }

        // 메뉴를 추가할 지 말 지를 물어본다.
        String yesOrNo = "";
        if (ableCount > 0) {
            System.out.println("메뉴를 추가할까요?(Y/N)");
            yesOrNo = sc.next();
            // 무조건 대문자로 바꿔준다.
            yesOrNo = yesOrNo.toUpperCase();
            switch (yesOrNo) {
                case "Y" :
                    String newMenu = "";
                    int newPrice = 0;
                    System.out.println("새로 추가할 메뉴명을 입력하세요.");
                    newMenu = sc.next();
                    System.out.println("메뉴의 가격을 입력하세요");
                    newPrice = sc.nextInt();

                    // 새로운 메뉴를 배열에 추가한다.(products, price)
                    // 어디에 넣을까?
                    // for loop 로 추가하기
                    for (int i = 0; i < MENU_COUNT; i++) {
                        if (products[i] == null) {
                            // 제품과 단가를 추가한다.
                            products[i] = newMenu;
                            price[i] = newPrice;
                            viewMenu();
                            return;
                        }
                    }
                    // 색인을 갖고 하는 방법
                    //products[MENU_COUNT - ableCount] = newMenu;
                    //price[MENU_COUNT - ableCount] = newPrice;
                    break;
                case "N":
                    System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘 못 입력했어요.");
                    System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
            }
        } else {
            System.out.println("관리자 메뉴로 돌아갑니다.");
            return;
        }
    }

    private static void menuUpdate() {
        while (true) {
            viewMenu();
            System.out.println("수정할 메뉴 번호를 입력하세요.");
            int updateMenuNumber = sc.nextInt();
            // 현재의 아이스아메리카노 가격은 2000 입니다.  -> 출력
            if (updateMenuNumber == 0) return;
            if (updateMenuNumber >= 1 && updateMenuNumber <= MENU_COUNT) {
                if (products[updateMenuNumber - 1] != null) {
                    // 존재하는 메뉴를 선택한 경우
                    System.out.println("현재의 " + products[updateMenuNumber - 1] +
                            "가격은 " + price[updateMenuNumber - 1] + "입니다.");
                    // 변경한 단가를 요구한다.
                    System.out.println("수정할 가격을 입력하세요.");
                    int updatePrice = sc.nextInt();
                    price[updateMenuNumber - 1] = updatePrice;
                    System.out.println("정상적으로 수정되었습니다.");
                    viewMenu();
                    continue;
                } else {
                    System.out.println("없는 메뉴입니다.");
                    continue;
                }
            } else {
                System.out.println("없는 메뉴입니다.");
                continue;
            }
        }
    }

    // 사용자 메뉴 보이기
    private static void order() {
        while (true) {
            viewMenu();

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

    private static void viewMenu() {
        System.out.println("메가 커피 메뉴");
        System.out.println("---------------------------------");
        // 배열을 읽어서 메뉴와 가격을 출력
        for (int i = 0; i < MENU_COUNT; i++) {
            if (products[i] != null) {
                String strMenu = (i+1) + " / " + products[i] + " / " + price[i];
                System.out.println(strMenu);
            }
        }
        System.out.println("---------------------------------");
        System.out.println("0. 돌아가기");
    }
}
