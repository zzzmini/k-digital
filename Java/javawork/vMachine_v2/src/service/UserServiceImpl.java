package service;

import myInterface.UserInterface;
import vo.ProductVO;

import java.util.Scanner;

public class UserServiceImpl implements UserInterface {
    Scanner sc = new Scanner(System.in);
    @Override
    public void insertCoin() {
        int ch = 0;
        do {
            System.out.println("돈을 넣어주세요");
            System.out.println("1: 5,000원, 2: 1,000원, 3: 500원, 4:100원");
            ch = sc.nextInt();
        } while (ch < 1 || ch > 4);

        switch (ch) {
            case 1:
                System.out.println("투입금액 : 5,000원");
                InitClazz.remainMoney = InitClazz.remainMoney + 5000;
                break;
            case 2:
                System.out.println("투입금액 : 1,000원");
                InitClazz.remainMoney = InitClazz.remainMoney + 1000;
                break;
            case 3:
                System.out.println("투입금액 : 500원");
                InitClazz.remainMoney = InitClazz.remainMoney + 500;
                break;
            case 4:
                System.out.println("투입금액 : 100원");
                InitClazz.remainMoney = InitClazz.remainMoney + 100;
                break;
        }
        System.out.println("사용 가능 금액 : " + InitClazz.remainMoney);
    }
    @Override
    public void returnCoin() {
        if(InitClazz.remainMoney==0){
            System.out.println("반환 할 금액이 없습니다.");
        } else {
            System.out.println(InitClazz.remainMoney + "원 반환 완료");
            InitClazz.remainMoney = 0;
            System.out.println("사용 가능 금액 : " + InitClazz.remainMoney +"원");
        }
    }

    @Override
    public void choiceMenu() {
        String menu;
        boolean flag = true;
        InitClazz.printMenu();
        System.out.println("원하는 제품명을 입력하세요");
        menu = sc.next();
        for(ProductVO product : InitClazz.lists){
            if(menu.equals(product.getDrinkName())){
                InitClazz.remainMoney = InitClazz.remainMoney - product.getDrinkPrice();
                product.setDrinkStock(product.getDrinkStock()-1);
                System.out.println(menu +  "출력 완료, 남은 돈 : " + InitClazz.remainMoney
                        + ", 재고 : " + product.getDrinkStock());
                flag = false;
            }
        }
        if(flag==true){
            System.out.println("찾는 메뉴가 없습니다.");
        }
    }
}
