package quiz_01;

import java.util.Scanner;

public class Q_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String star = "";
        for (int i = 5; i >= 1; i--) {
            star = "*".repeat(i);
            System.out.println(star);
        }

        star = "";
        for (int j = 5; j >= 1; j--) {
            for (int k = 1; k <= j; k++) {
                star = star + "*";
            }
            System.out.println(star);
            star = "";
        }
    }
}
