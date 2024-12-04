package basic;

import java.util.Arrays;
import java.util.Scanner;

public class JuminCheck {
    public static void main(String[] args) {
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("주민번호 13자리를 연속해서 입력하세요(- 제외)");
        // 404164140818
        String[] strJumin = scanner.next().split("");

        // 정수 담는 연속배열 13개를 선언
        int[] jumin = new int[strJumin.length];
        for (int i = 0; i < strJumin.length; i++) {
            jumin[i] = Integer.parseInt(strJumin[i]);
        }
        // 각 자릿수에다가 2,3,4,5,6,7,8,9,2,3,4,5 곱하기
        for (int i = 0; i < jumin.length - 1; i++) {
            if (i < 8) {
                result = result + (jumin[i] * (i + 2));
            } else {
                result = result + (jumin[i] * (i - 6));
            }
        }
        // 결과 = 11로 나눈 나머지
        result = result % 11;
        // 결과 = 11 - 결과
        result = 11 - result;
        // 결과 = 결과를 10으로 나눈 나머지
        result = result % 10;

        // 맞는지 틀리는지: 결과 == jumin[12]
        if (result == jumin[12]) {
            System.out.println("옳바른 주민번호입니다.");
        } else {
            System.out.println("잘못된 주민번호입니다.");
        }
    }
}
