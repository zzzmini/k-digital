package quiz_01;

import java.util.Scanner;

public class Q_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                sum = sum + j;
//                sum += i;
            }
        }
    }
}
