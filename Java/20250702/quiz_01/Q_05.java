package quiz_01;

import java.util.Scanner;

public class Q_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coin = sc.nextInt();
        int restCoin = coin;

        System.out.println("1,000원 : " + (restCoin/1000) + "개");
        restCoin = restCoin % 1000;
        System.out.println("남은금액 : " + restCoin + "원 ");

        System.out.println("500원 : " + (restCoin/500) + "개");
        restCoin = restCoin % 500;
        System.out.println("남은금액 : " + restCoin + "원 ");

        System.out.println("100원 : " + (restCoin/100) + "개");
        restCoin = restCoin % 100;
        System.out.println("남은금액 : " + restCoin + "원 ");

        System.out.println("50원 : " + (restCoin/50) + "개");
        restCoin = restCoin % 50;
        System.out.println("남은금액 : " + restCoin + "원 ");

        System.out.println("10원 : " + (restCoin/10) + "개");
        restCoin = restCoin % 10;
        System.out.println("남은금액 : " + restCoin + "원 ");
    }
}
