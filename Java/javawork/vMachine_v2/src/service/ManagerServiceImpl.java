package service;

import myInterface.ManagerInterface;
import vo.ProductVO;

import java.util.Scanner;

public class ManagerServiceImpl implements ManagerInterface {
    Scanner sc = new Scanner(System.in);
    @Override
    public void enterMenu() {
        String name;
        int price;
        int stock;

        boolean flag = true;

        InitClazz.printMenu();

        System.out.println("자판기 메뉴 등록");
        System.out.println("제품 이름을 입력하세요");
        name = sc.next();
        for(ProductVO product : InitClazz.lists){
            if(name.equals(product.getDrinkName())){
                System.out.println("이미 상품이 있습니다.");
                flag = false;
                return;
            }
        }
        if(flag==true){
            //상품입력
            System.out.println("제품의 가격?(숫자만 입력)");
            price = sc.nextInt();
            System.out.println("재고 등록(채울 개수)");
            stock = sc.nextInt();
            InitClazz.lists.add(ProductVO.of(name, price,stock));
        }
    }

    @Override
    public void deleteMenu() {
        InitClazz.printMenu();
        boolean flag = true;
        String name;

        System.out.println("삭제할 제품명 입력 : ");
        name = sc.next();
        for(ProductVO product : InitClazz.lists){
            if(name.equals(product.getDrinkName())){
                // 삭제
                System.out.println(name + "삭제 완료");
                InitClazz.lists.remove(product);
                flag = false;
                return;
            }
        }
        if(flag==true){
            System.out.println("삭제할 제품이 존재하지 않습니다.");
        }
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
        InitClazz.printMenu();

        System.out.println("재고를 수정 할 제품명 입력");
        String item = sc.next();
        if (InitClazz.lists.isEmpty()) {
            System.out.println("재고 수정할 상품이 존재하지 않습니다.");
            return;
        } else {
            boolean flag = true;
            for (ProductVO product : InitClazz.lists) {
                if (item.equals(product.getDrinkName())) {
                    System.out.println("(수정) 재고 수량?(숫자만 입력)");
                    int updateStock = sc.nextInt();
                    product.setDrinkStock(product.getDrinkStock() + updateStock);
                    flag = false;
                    break;
                }
            }
            if(flag == true) System.out.println("입력한 상품이 존재하지 않습니다.");
        }
        InitClazz.printMenu();
    }
}
