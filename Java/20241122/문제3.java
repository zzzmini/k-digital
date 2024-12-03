package basic.exam;

public class 문제3 {
    public static void main(String[] args) {
        // 1부터 20까지의 수를 출력하세요.
        // (단, 2의 배수일 때만 출력하세요)
        // 1. 2씩 증가해서 출력
        for (int i = 2; i <= 20; i=i+2) {
            System.out.println("i = " + i);
        }
        // 2. 짝수를 확인해서 처리하는 방법
        // i % 2 == 0
        for (int i = 1; i <= 20; i++) {
            if ((i % 2) == 0) {
                System.out.println("i = " + i);
            }
        }
    }
}
