package quiz_01;

import java.util.Scanner;

public class Q_06 {
    public static void main(String[] args) {
        // 두 수를 차례로 입력
        Scanner sc = new Scanner(System.in);
        // 첫 번째 수
        System.out.println("첫 번째 값을 입력");
        int intA = sc.nextInt();
        // 두 번째 수
        System.out.println("두 번째 값을 입력");
        int intB = sc.nextInt();
        System.out.println("intA + intB = " +(intA+intB));
    }
}
