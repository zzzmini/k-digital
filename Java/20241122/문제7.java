package basic.exam;

import java.util.Scanner;

public class 문제7 {
    public static void main(String[] args) {
        // 두 정수 A와 B를 입력받은 다음,
        // 두 수 A와 B 사이의 모든 정수값의 합
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 수를 입력하세요 : ");
        int firstNumber = sc.nextInt();
        System.out.println("두번째 수를 입력하세요 : ");
        int secondNumber = sc.nextInt();
        // 두 수를 비교해서 첫째 값이 더 크면 두 수를 바꿔준다.
        if (firstNumber > secondNumber) {
            int temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        int sum = 0;
        for (int i = firstNumber; i <= secondNumber; i++) {
            sum = sum + i;
        }
        System.out.println("두 수 사이의 합은 : " + sum);
    }
}
