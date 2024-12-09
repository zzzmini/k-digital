import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] product = new String[5]; // 제품명
    static int[] price = new int[5]; // 가격
    static int[] stock = new int[5]; // 재고수량
    // 전체 수익금액을 관리하는 변수
    static int totalMoney = 0;
    // 맨 처음 접속인지 확인
    static boolean first = true;

    public static void main(String[] args) {
        initialize();
        user();
    }

    private static void user() {
        // 사용자가 입력한 돈을 잠시 저장하는 변수
        int userMoney = 0;
        while (true) {
            showTitle();
            // 돈을 입력받는 작업은 프로그램 시작한 후 한번만 보여주면 된다.
            if (first == true) {
                System.out.println("돈을 넣어주세요");
                userMoney = sc.nextInt();
                first = false;
            }

            // 만약에 1004 가 입력되면 관리자 모드로 진입
            if (userMoney == 1004) {
                admin();
            } else {
                int number = 0;
                System.out.println("메뉴입력");
                number = sc.nextInt();
                //사용자가 선택한 제품을 조건에 따라 제공하는 기능
                //제공할 제품의 금액과 입력한 금액을 비교
                // 현재 재고가 있는지 비교
                if (stock[number - 1] == 0) {
                    System.out.println("해당 제품은 현재 재고가 0 입니다.");
                    System.out.println("관리자에게 문의하세요");
                    break;
                }
                if (price[number - 1] <= userMoney) {
                    // 금액이 충분하니까 제품 공급, 수익 금액에 추가, 재고 변경
                    System.out.println(product[number-1] + "이(가) 나왔다.");
                    // 잔액 차감
                    userMoney = userMoney - price[number - 1];
                    // 잔액 출력
                    System.out.println("잔액 : " + userMoney);
                    // 재고 조정하기
                    stock[number-1] = stock[number-1] - 1;
                } else {
                    System.out.println("잔액이 부족합니다.");
                    // 잔액 출력
                    System.out.println("잔액 : " + userMoney);
                    selectMenu(userMoney);
                }
            }
        }
    }
    private static void selectMenu(int userMoney) {
        int selectNumber = 0;
        System.out.println("1:계속구매하기 2:금액추가하기 3:잔돈반환하기");
        while (true) {
            System.out.println("메뉴입력:");
            selectNumber = sc.nextInt();
            switch (selectNumber) {
                case 1: // 계속구매
                    return;
                case 2: // 금액추가
                    System.out.println("추가할 금액을 입려하세요");
                    int addMoney = sc.nextInt();
                    userMoney = userMoney + addMoney;
                    return;
                case 3: // 잔돈반환
                    System.out.println("거스름 돈 " + userMoney + "원이 반환 됩니다.");
                    System.out.println("감사합니다. 다음에 또 이용해 주세요!!");
                    first = true;
                    return;
                default:
                    System.out.println("입력오류");
                    break;
            }
        }
    }
    private static void admin() {
        int number = 0;
        while (true) {
            System.out.println("========================");
            System.out.println("관리자 페이지입니다.");
            System.out.println("1.메뉴변경 2.가격변경 3.재고추가 4.메뉴추가 5.수입확인(종료는 -1)");
            System.out.println("========================");
            System.out.println("변호를 입력하세요");
            number = sc.nextInt();
            switch (number) {
                case -1:
                    System.out.println("관리자페이지 종료");
                    return;
                case 1:
                    System.out.println("변경하실 메뉴의 번호를 입력하세요");
                    int munu = sc.nextInt();
                    System.out.println(product[munu-1] + "을(를) 무엇으로 바꾸시겠습니까?");
                    String munuName = sc.next();
                    product[munu - 1] = munuName;
                    System.out.println(munuName + "의 가격은 얼마입니까?");
                    int menuPrice = sc.nextInt();
                    price[munu - 1] = menuPrice;
                    System.out.println(munuName + "의 재고를 몇 개 등록 하시겠습니까?");
                    int munuStock = sc.nextInt();
                    stock[munu - 1] = stock[munu - 1] + munuStock;
                    showTitle();
                    break;
                case 2:
                    int updateNumber;
                    System.out.println("가격을 변경하실 메뉴의 번호를 입력하세요.");
                    updateNumber = sc.nextInt();
                    System.out.println(product[updateNumber-1] + "의 가격을 얼마로 바꾸시겠습니까?");
                    int updatePrice = sc.nextInt();
                    price[updateNumber - 1] = updatePrice;
                    System.out.println("가격 변경이 완료 되었습니다.");
                    showTitle();
                    break;
                case 3:
                    System.out.println("재고를 추가하실 메뉴의 번호를 입력하세요.");
                    updateNumber = sc.nextInt();
                    System.out.println(product[updateNumber-1] + "를 몇 개 추가하시겠습니까?");
                    int updateStock = sc.nextInt();
                    stock[updateNumber - 1] = stock[updateNumber - 1] + updateStock;
                    System.out.println("재고 추가가 완료 되었습니다.");
                    showTitle();
                    break;
                case 4:
                    // 추가할 메뉴의 자리가 있는지 확인
                    // 현재 추가할 지리가 있는지 확인
                    boolean flag = false;

                    for (int i = 0; i < product.length; i++) {
                        if (product[i] == null) {
                            flag = true;
                            // 추가 작업 진행
                            System.out.println("추가하실 메뉴의 이름을 입력하세요 : ");
                            product[i] = sc.next();
                            System.out.println("추가하실 메뉴의 가격을 입력하세요 : ");
                            price[i] = sc.nextInt();
                            System.out.println(product[i] + "재고는 몇 개 입니까");
                            stock[i] = sc.nextInt();
                            System.out.println("메뉴 추가가 완료 되었습니다.");
                            showTitle();
                            break;
                        }
                    }
                    if (flag == false) {
                        System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다.");
                    }
                    break;
                case 5:
                    System.out.println("========================");
                    System.out.println("현재까지의 수익은 " + totalMoney + "입니다.");
                    System.out.println("========================");
                    break;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
        }

    }

    private static void showTitle() {
        System.out.println("=========================");
        System.out.println("자판기입니다.(번호:상품(가격)-재고");
        String menu = "";
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                menu = menu + (i + 1) + "." + product[i] +
                        "(" + price[i] + "W)-" + stock[i] + "개 ";
            }
        }
        System.out.println(menu);
        System.out.println("=========================");
    }

    private static void initialize() {
        // 콜라 정보
        product[0] = "콜라";
        price[0] = 500;
        stock[0] = 3;

        // 콜라 정보
        product[1] = "사이다";
        price[1] = 700;
        stock[1] = 3;

        // 콜라 정보
        product[2] = "커피";
        price[2] = 1500;
        stock[2] = 3;
    }
}
