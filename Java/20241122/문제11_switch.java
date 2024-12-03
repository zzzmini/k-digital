package basic.exam;

import java.util.Scanner;

public class 문제11_switch {
    public static void main(String[] args) {
//        시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B,
//        70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();
        score = score / 10;
        switch (score) {
            case 10:
                System.out.println("당신의 결과는 : A");
                break;
            case 9:
                System.out.println("당신의 결과는 : A");
                break;
            case 8:
                System.out.println("당신의 결과는 : B");
                break;
            case 7:
                System.out.println("당신의 결과는 : C");
                break;
            case 6:
                System.out.println("당신의 결과는 : D");
                break;
            default:
                System.out.println("당신의 결과는 : F");
        }
    }
}
