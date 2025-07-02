package quiz_01;

import java.util.Scanner;

public class Q_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("출력할 구구단의 단수 입력");
        int dan = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            int value = dan * i;
            System.out.println(dan + " × " + i  + " = " + value);
        }
    }
}
