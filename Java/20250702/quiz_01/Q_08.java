package quiz_01;

import java.util.Scanner;

public class Q_08 {
    // 별찍기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String star = "";
        for (int i = 1; i <= line; i++) {
            star = "*".repeat(i);
            System.out.println(star);
        }

        star = "";
        for (int j = 1; j <= line; j++) {
            for (int k = 1; k <= j; k++) {
                star = star + "*";
            }
            System.out.println(star);
            star = "";
        }
    }
}
