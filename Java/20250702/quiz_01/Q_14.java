package quiz_01;

import java.util.Scanner;

public class Q_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째");
        int dice_1 = sc.nextInt();
        System.out.println("두번째");
        int dice_2 = sc.nextInt();
        System.out.println("세번째");
        int dice_3 = sc.nextInt();
        // 몇 개가 일치하는 지 카운트 할 변수
        int sameCount = 0;
        // 상금에 사용한 주사위 눈 값
        int dice_number = 0;
        int max = Integer.MIN_VALUE;
        // 총 상금 넣을 변수
        int total = 0;

        // 순서대로 같은지 비교하면서 count
        if (dice_1 == dice_2) {
            sameCount = sameCount + 1;
            dice_number = dice_1;
        }
        if (dice_2 == dice_3) {
            sameCount = sameCount + 1;
            dice_number = dice_2;
        }
        if (dice_1 == dice_3) {
            sameCount = sameCount + 1;
            dice_number = dice_1;
        }
        switch (sameCount) {
            case 3:
                // 3개 일치
                total = 10000 + (dice_number) * 1000;
                break;
            case 1:
                // 2개 일치
                total = 1000 + (dice_number) * 100;
                break;
            case 0:
                // 다 틀릴 때
                // 가장 큰 주사위를 찾아요
                if(dice_1 > max) max = dice_1;
                if(dice_2 > max) max = dice_2;
                if(dice_3 > max) max = dice_3;

                total = max *100;
                break;
        }
        System.out.println("상금 : " + total);
    }
}
