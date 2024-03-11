package ch06;

import java.util.Scanner;

public class SwitchEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int day = sc.nextInt();
        switch (day){
            case 0:
                System.out.println("일요일");
                break;
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            default:
                System.out.println("감사합니다.");
        }
//        if(day == 0){
//            System.out.println("일요일");
//        } else if (day == 1) {
//            System.out.println("월요일");
//        } else if (day == 2) {
//            System.out.println("화요일");
//        } else if (day == 3) {
//            System.out.println("수요일");
//        }
    }
}
