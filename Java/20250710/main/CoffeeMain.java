package main;

import view.AdminView;
import view.UserView;
import vo.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMain {
    //커피를 담는 리스트를 선언
    public static List<Coffee> coffeeList = new ArrayList<>();

    public static void main(String[] args) {
        // 고객화면과 관리자 화면 인스턴스 생성
        UserView userView = new UserView();
        AdminView adminView = new AdminView();

        coffeeInit();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("메가 커피에요.");
            System.out.println("무엇을 도와드릴까요?");
            System.out.println("1. 주문하기  2. 관리자  3. 종료하기");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    userView.userScreen();
                    break;
                case 2:
                    System.out.println("관리자 비밀번호 입력 : ");
                    String password = sc.next();
                    if (password.equals("1004")) {
                        adminView.adminScreen();
                    }
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void coffeeInit() {
        // 3개 커피 만들어서 리스트에 담기
        Coffee americano = new Coffee();
        americano.setProduct("아메리카노");
        americano.setPrice(1800);
        coffeeList.add(americano);
        Coffee ice = new Coffee();
        ice.setProduct("아이스아메리카노");
        ice.setPrice(2000);
        coffeeList.add(ice);
        Coffee megari = new Coffee();
        megari.setProduct("메가리");
        megari.setPrice(3000);
        coffeeList.add(megari);
    }
}
