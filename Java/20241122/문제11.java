package basic.exam;

import java.util.Scanner;

public class 문제11 {
    public static void main(String[] args) {
//        시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B,
//        70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("당신의 결과는 : A");
        } else if (score >= 80) {
            System.out.println("당신의 결과는 : B");
        } else if (score >= 70) {
            System.out.println("당신의 결과는 : C");
        } else if (score >= 60) {
            System.out.println("당신의 결과는 : D");
        } else
            System.out.println("당신의 결과는 : F");
    }
}
