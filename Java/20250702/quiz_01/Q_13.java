package quiz_01;

import java.util.Scanner;

public class Q_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시간");
        int hour = sc.nextInt();
        System.out.println("분");
        int minute = sc.nextInt();
        System.out.println("요리시간");
        int cookingTime = sc.nextInt();
        // 총 분으로 전환
        int totalTime = (hour * 60) + minute + cookingTime;
        // 요리 종료 시간 -> 분은 버리고 시간만 계산
        hour = (totalTime / 60);
        // 24시간제 이니까 24로 나눈 나머지 취하기
        hour = hour % 24;
        // 요리 종료 분
        minute = totalTime % 60;
        System.out.println(hour + " " + minute);
    }
}
