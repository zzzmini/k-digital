package quiz_01;

import java.util.Scanner;

public class Q_07 {
    public static void main(String[] args) {
        // 두 수를 차례로 입력
        Scanner sc = new Scanner(System.in);
        // 첫 번째 수
        System.out.println("첫 번째 값을 입력");
        int intA = sc.nextInt();
        // 두 번째 수
        System.out.println("두 번째 값을 입력");
        int intB = sc.nextInt();

        // 첫번째 수가 두번째 수보다 크면 두 수를 바꾼다.
        if (intA > intB) {
            int temp = intA;
            intA = intB;
            intB = temp;
        }
        int sum = 0;
        for (int i = intA; i <= intB; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
