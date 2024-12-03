package basic.exam;

import java.util.Scanner;

public class 문제14 {
    public static void main(String[] args) {
//        ⓐ 같은 눈이 3개가 나오면
//        -- 상금 : 10,000원 + (같은 눈) × 1,000원
//        ⓑ 같은 눈이 2개만 나오는 경우에는
//        -- 상금 : 1,000원 + (같은 눈) × 100원
//        ⓒ 모두 다른 눈이 나오는 경우에는
//        -- 상금 : (그 중 가장 큰 눈) × 100원
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 주사위 값 : ");
        int dice_1 = sc.nextInt();
        System.out.println("두번째 주사위 값 : ");
        int dice_2 = sc.nextInt();
        System.out.println("세번째 주사위 값 : ");
        int dice_3 = sc.nextInt();

        // 1. 가장 큰값 구하기
        int max = 0;
        if (dice_1 > max) max = dice_1;
        if (dice_2 > max) max = dice_2;
        if (dice_3 > max) max = dice_3;
        System.out.println("max = " + max);
        // 몇 개 주사위 값이 같은지 확인
        // 같은 주사위 수 : same
        int same = 0;
        // 같은 눈의 수
        int sameNumber = 0;
        if (dice_1 == dice_2) {
            same = same + 1;
            sameNumber = dice_1;
        }
        if (dice_1 == dice_3) {
            same = same + 1;
            sameNumber = dice_1;
        }
        if (dice_2 == dice_3) {
            same = same + 1;
            sameNumber = dice_2;
        }
        System.out.println("same = " + same);
        //상금계산
        int result = 0;
        switch (same) {
            case 3:
                // 상금 : 10,000원 + (같은 눈) × 1,000원
                result = 10000 + (sameNumber * 1000);
                break;
            case 1:
                // 상금 : 1,000원 + (같은 눈) × 100원
                result = 1000 + (sameNumber * 100);
                break;
            default:
                // 상금 : (그 중 가장 큰 눈) × 100원
                result = max * 100;
        }
        System.out.println("상금은 " + result);
    }
}
