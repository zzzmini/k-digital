package service;

import init.InitClass;
import java.util.Scanner;

public class AdminService {
    Scanner sc = new Scanner(System.in);
    public void updateMenu(){
        System.out.print("변경하실 메뉴의 번호를 입력하세요(1~"+(InitClass.productCount+1)+"):");
        int i = sc.nextInt();
        System.out.print(InitClass.product[i-1]+"를(을) 무엇으로 바꾸시겠습니까?:");
        sc.nextLine();
        String name=sc.next();
        System.out.print(name+"의 가격은 얼마입니까?");
        int v = sc.nextInt();
        System.out.print(name+"의 재고를 몇 개 등록 하시겠습니까?:");
        int n = sc.nextInt();
        InitClass.product[i-1]=name;
        InitClass.price[i-1]=v;
        InitClass.stock[i-1]=n;
        System.out.println("메뉴 변경이 완료되었습니다!");
    }
    public void updatePrice(){
        System.out.print("가격을 변경하실 메뉴의 번호를 입력하세요(1~"+(InitClass.productCount+1)+"):");
        int i = sc.nextInt();
        System.out.print(InitClass.product[i-1]+"의 가격을 얼마로 바꾸시겠습니까?:");
        int j = sc.nextInt();
        InitClass.price[i-1]=j;
        System.out.println("가격 변경이 완료 되었습니다!");
    }
    public void updateStock(){
        System.out.print("재고를 추가하실 메뉴의 번호를 입력하세요(1~"+(InitClass.productCount+1)+"):");
        int i = sc.nextInt();
        System.out.print(InitClass.product[i-1]+"를(을) 몇 개 추가 하시겠습니까?:");
        int j = sc.nextInt();
        InitClass.stock[i-1]+=j;
        System.out.println("재고 추가가 완료 되었습니다!");
    }
    public void addMenu(){
        System.out.print("추가하실 메뉴의 가격을 입력하세요:");
        int i =sc.nextInt();
        System.out.print("추가하실 메뉴의 이름을 입력하세요:");
        sc.nextLine();
        String name = sc.next();
        System.out.print(name+"의 재고는 몇 개 입니까?:");
        int j =sc.nextInt();
        InitClass.product[InitClass.productCount+1]=name;
        InitClass.price[InitClass.productCount+1]=i;
        InitClass.stock[InitClass.productCount+1]=j;
        InitClass.productCount++;
        System.out.println("메뉴 추가가 완료 되었습니다!");
    }
    public void confirmProfit(){
        System.out.println("현재까지의 수익은"+InitClass.profit+"입니다.");
    }
}
