package basic.exam;

public class 문제2 {
    public static void main(String[] args) {
        // 1. 10부터 1까지 출력
        // 2. 3일 때 출력 제외
        for (int i = 10; i >= 1; i--) {
            if(i == 3) {
                continue;
            }
            System.out.println("i = " + i);
        }
        // while
        int j = 11;
        while (j > 1) {
            j --;
            if(j == 3) {
                continue;
            }
            System.out.println("j = " + j);
        }
    }
}
