package ch02;

public class TotalGugudan {
    public static void main(String[] args) {
        // for 구문을 중첩해서 구구단을 출력해 봅시다.
        // 단을 회전하는 for-loop
        for (int i = 2; i <= 9; i++) {
            if(i == 4) break;
            System.out.println("=== " + i + " 단 ===");

            // 1 ~ 9까지 변하면서 곱하는 작업
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i*j));
                if (j == 5) {
                    break;
                }
            }
        }
    }
}
