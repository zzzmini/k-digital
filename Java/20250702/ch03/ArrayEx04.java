package ch03;

import java.util.Scanner;

public class ArrayEx04 {
    public static void main(String[] args) {
        // 스캐너로 주사위 값을 세번
        Scanner sc = new Scanner(System.in);
        System.out.println("세개의 주사위 값을 입력하세요");
        String numbers = sc.next();
        // numbers = "123";
        String[] strNumbers = numbers.split("");
        // 정수로 바꿔서 담을 정수배열이 필요해요.
        int[] diceNumber = new int[strNumbers.length];

        // 문자 배열를 숫자 배열로 바꿔준다.
        for (int i = 0; i < numbers.length(); i++) {
            diceNumber[i] = Integer.parseInt(strNumbers[i]);
            System.out.println(diceNumber[i]);
        }

    }
}
