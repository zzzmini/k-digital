package service;

import myInterface.ManagerInterface;
import vo.ProductVO;

import java.util.Scanner;

public class ManagerServiceImpl implements ManagerInterface {
    Scanner sc = new Scanner(System.in);
    @Override
    public void enterMenu() {
        System.out.println("관리자 메뉴 - 메뉴등록");
    }

    @Override
    public void deleteMenu() {
        System.out.println("관리자 메뉴 - 메뉴삭제");
    }

    @Override
    public void updateMenu() {
        InitClazz.printMenu();

        System.out.println("수정 할 제품명 입력 : ");
        String item = sc.next();
        if (InitClazz.lists.isEmpty()) {
            System.out.println("수정할 상품이 존재하지 않습니다.");
            return;
        } else {
            boolean flag = true;
            for (ProductVO product : InitClazz.lists) {
                if (item.equals(product.getDrinkName())) {
                    System.out.println("(수정) 메뉴 이름? ");
                    product.setDrinkName(sc.next());
                    System.out.println("(수정) 메뉴 가격 ?(숫자만 입력)");
                    product.setDrinkPrice(sc.nextInt());
                    System.out.println("(수정) 재고 수량?(숫자만 입력)");
                    product.setDrinkStock(sc.nextInt());
                    flag = false;
                    break;
                }
            }
            if(flag == true) System.out.println("입력한 상품이 존재하지 않습니다.");
        }
    }

    @Override
    public void enterStock() {
        System.out.println("관리자 메뉴 - 재고등록");
    }
}
