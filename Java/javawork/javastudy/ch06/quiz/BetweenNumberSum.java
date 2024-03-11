package ch06.quiz;

import java.util.Scanner;

public class BetweenNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intNum1 = 0;
        int intNum2 = 0;
        int sum = 0;
        int temp;
        String yesOrNo = "";
//        do {
//            System.out.println("계속하시겠습니까?(Y/N)");
//            yesOrNo = sc.next();
//        } while (yesOrNo.equals("Y"));
        while (true){
            System.out.println("첫 번째 수를 입력하세요 : ");
            intNum1 = sc.nextInt();
            System.out.println("두 번째 수를 입력하세요 : ");
            intNum2 = sc.nextInt();
            // 두수를 비교해서 첫번째가 크면 두수를 바꿉니다.
            if(intNum1 > intNum2){
                temp = intNum1;
                intNum1 = intNum2;
                intNum2 = temp;
            }
            for(int i = intNum1; i <= intNum2; i++){
                sum = sum + i;
            }
            System.out.println("두 수 " + intNum1 + "과 " +
                    intNum2 + " 사이의 합은" + sum + "입니다.");

            System.out.println("계속하시겠습니까?(Y/N)");
            yesOrNo = sc.next();
            if(yesOrNo.equals("N")) break;
        }
    }
}
