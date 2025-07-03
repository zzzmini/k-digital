package quiz_02;

import java.util.Scanner;

public class JuminCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 주민번호 13자리를 문자로 입력받기
        System.out.printf("주민번호를 입력하세요.(단, - 제외)");
        String input = sc.next();
        // 주민번호를 문자열 배열로 쪼개서 넣는다.
        String[] arrayInput = input.split("");
        // 문자 -> 숫자 배열로 저장할 정수배열을 선언
        int[] juminNumber = new int[arrayInput.length];

        // 잘되는지 출력하기
        for (String x : arrayInput) {
            System.out.println(x);
        }
        // 문자 배열을 숫자배열로 바꾸기
        for (int i = 0; i < arrayInput.length; i++) {
            juminNumber[i] = Integer.parseInt(arrayInput[i]);
        }
        // 주민번호 확인하기
        // 1. 각 배열 요소에 2,3,4,5,6,7,8,9,2,3,4,5를 곱한다.
        // 모두 더한다.
        int sum = 0;
        for (int i = 0; i < juminNumber.length - 1; i++) {
            if (i <= 7) {
                sum = sum + juminNumber[i] * (i + 2);
            } else {
                sum = sum + juminNumber[i] * (i - 6);
            }
        }
        // 위 조건에 맞는 합이 sum에 들어간다.
        // 2. sum을 11로 나눈 나머지
        sum = sum % 11;
        // 3. 11- sum
        sum = 11 - sum;
        // 4. sum을 10로 나눈 나머지
        sum = sum % 10;
        // 5. 13번째와 비교하기
        if (sum == juminNumber[12]) {
            System.out.println("맞아요");
        } else {
            System.out.println("틀려요");
        }
    }
}
