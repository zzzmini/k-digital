package ch02;

import java.util.Scanner;

public class ThreeNumberTest {
    // 세 수를 차례로 입력받아요.
    // 가장 큰수와 가장 작은 수를 출력합니다.
    static Scanner sc = new Scanner(System.in);
    // 위에 적은 스캐너를 공용으로 사용하기 위해...
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        System.out.println("세 수를 차례로 입력하세요");
        // 처음 입력값을 a에 넣어준다.
        a = sc.nextInt();
        // 두번째 수를 a에 입력받는다.
        b = sc.nextInt();
        // 세번째 수를 b에 입력받는다.
        c = sc.nextInt();
        // a 와 b를 비교해서 큰 수는 maxValue,
        // 작은 수는 minValue에 넣는다.
        if (a > b) {
            maxValue = a;
            minValue = b;
        } else {
            maxValue = b;
            minValue = a;
        }
        // c 가 maxValue 보다 크면 c-> maxValue
        if (c > maxValue) {
            maxValue = c;
        }
        // c 가 minValue 보다 작으면 c-> minValue
        if (c < minValue) {
            minValue = c;
        }
        System.out.println("Max : " + maxValue);
        System.out.println("Min : " + minValue);
    }
}
