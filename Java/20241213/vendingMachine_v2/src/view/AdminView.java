package view;

import service.AdminService;
import vo.Product;

import java.util.Scanner;

public class AdminView {

    AdminService adminService = new AdminService();

    Scanner sc = new Scanner(System.in);

    public void insertMenu() {
        // 비어있는 Product 를 하나 생성
//        Product product = new Product();
        String item;
        int price;
        int stock;

        System.out.println("자판기 메뉴 등록");
        System.out.println("제품 이름을 입력하세요");
        item = sc.next();
        System.out.println("제품의 가격?(숫자만 입력)");
        price = sc.nextInt();
        System.out.println("재고 등록(채울 개수)");
        stock = sc.nextInt();
//        product.setItem(item);
//        product.setPrice(price);
//        product.setStock(stock);
        Product product = new Product(item, price, stock);
        adminService.insertItem(product);
    }

    public void deleteMenu() {
        System.out.println("관리자 메뉴삭제 화면");
    }

    public void updateMenu() {
        System.out.println("관리자 메뉴수정 화면");
    }

    public void updateStock() {
        System.out.println("관리자 재고수정 화면");
    }

    public void viewAllList() {
        System.out.println("관리자 전체목록보기 화면");
    }
}
