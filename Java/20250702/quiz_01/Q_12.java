package quiz_01;

import java.util.Scanner;

public class Q_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시간");
        int hour = sc.nextInt();
        System.out.println("분");
        int minute = sc.nextInt();
        if (minute >= 45) {
            minute = minute - 45;
        } else if (hour == 0 && minute < 45) {
            hour = 23;
            minute = minute + 15;
        } else {
            hour = hour - 1;
            minute = minute + 15;
        }
        System.out.println(hour + " " + minute);
    }
}
