package init;

import java.util.Scanner;

public class InitClass {
//    public static Scanner sc = new Scanner(System.in);
    public static final int MAX = 5;   // 최대 취급 제품 수
    public static String[] product = new String[MAX];  // 제품배열
    public static int[] price = new int[MAX];  // 가격배열
    public static int[] stock = new int[MAX];  // 재고 수량 배열
    public static int currentMoney = 0;  //사용자가 넣은 돈
    public static int profit = 0; // 관리자의 총 수익 계산 용 변수
    public static int productCount = 3;

    public static void initialize(){
        product[0] = "콜라";
        price[0] = 500;
        stock[0] = 3;
        product[1] = "사이다";
        price[1] = 700;
        stock[1] = 4;
        product[2] = "커피";
        price[2]= 1500;
        stock[2] = 5;
    }
    public static void line(){
        System.out.println("=================================================");
    }
}
