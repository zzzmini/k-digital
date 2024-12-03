package basic.exam;

import java.util.Scanner;

public class 문제13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 시간 : ");
        int hour = sc.nextInt();
        System.out.println("현재 분 : ");
        int minute = sc.nextInt();
        System.out.println("요리 시간 : ");
        int time = sc.nextInt();
        //현재시각 + 요리시간 = 전체 요리 -> 분으로 표시
        int totalTime = (hour * 60) + minute + time;
        // 출력 시간(총시간을 60으로 나눈 몫)
        hour = (totalTime/60)%24;
        // 출력 분
        minute = totalTime % 60;
        System.out.println(hour + " " + minute);
    }
}
