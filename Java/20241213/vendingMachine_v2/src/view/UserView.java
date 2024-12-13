package view;

import service.AdminService;
import service.UserService;
import vo.Product;

import java.util.List;
import java.util.Scanner;

public class UserView {
    AdminService adminService = new AdminService();
    UserService userService = new UserService();

    // 사용자가 입력한 돈 관리용
    public static int userMoney;

    Scanner sc = new Scanner(System.in);

    public void insertCoin() {
        System.out.println("돈을 넣어주세요");
        System.out.println("1: 5,000원 2: 1,000원 3: 500원 4: 100원");
        int[] insertMoney = {5000, 1000, 500, 100};
        int number = sc.nextInt();
        switch (number) {
            case 1:
                userMoney = userMoney + insertMoney[number-1];
                break;
            case 2:
                userMoney = userMoney + insertMoney[number-1];
                break;
            case 3:
                userMoney = userMoney + insertMoney[number-1];
                break;
            case 4:
                userMoney = userMoney + insertMoney[number-1];
                break;
            default:
                System.out.println("잘 못 입력하셨습니다.");
        }
        if (number >= 1 || number <= 4) {
            System.out.println("투입 금액 : " + insertMoney[number-1] + "원");
        }
        System.out.println("사용가능 금액 : " + userMoney + "원");
    }

    public void returnMoney() {
        System.out.println(userMoney + "원 반환 완료");
        userMoney = 0;
        System.out.println("사용가능 금액 : " + userMoney + "원");
    }

    public void selectMenu() {
        List<Product> allList = adminService.getAllList();

        if (userMoney == 0) {
            System.out.println("동전을 먼저 투입하세요");
            return;
        }

        printHeader();
        if (allList.size() == 0) {
            System.out.println("현재 자판기에 제품이 없습니다.");
            return;
        } else {
            // 내용 출력
            for (Product x : allList) {
                System.out.println(x);
            }
        }
        printLine();

        System.out.println("원하는 제품명을 입력하세요");
        String itemName = sc.next();

        // 서비스에 요청
        boolean result = userService.serveItem(userMoney, itemName);

        // 결과 출력
        if (result) {
            System.out.printf(itemName + " 출력완료");
            System.out.printf(", 남은 금액 : " + userMoney);
            System.out.println();
        }
    }
    public void printHeader() {
        System.out.println("=========== 메뉴 ===========");
    }
    public void printLine() {
        System.out.println("=========================");
    }
}
