package ch02;

public class ReturnAndContinueAndBreak {
    public static void main(String[] args) {
        // 1부터 20까지의 합을 출력하는 프로그램을 만드세요.
        // 누적한 값을 저장하는 변수 선언
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

        // 문제 1. 합계가 150 을 넘는 최초의 i 값
        sum = 0;
        int goal = 0;
        for (int i = 1; i <= 20; i++) {
            sum = sum + i;
            if (sum > 30) {
                goal = i + 1;
                break;
            }
        }
        System.out.println("i = " + goal);

        // 문제 2. 1부터 10까지 더하는데 5를 제외하고 싶어요
        sum = 0;
        for (int k = 1; k <= 10; k++) {
            if (k == 5) continue;
            sum = sum + k;
        }

        // 문제 3. 1부터 10까지 루프 중 i == 5 이면
        // 프로그램 종료하기
        sum = 0;
        for (int k = 1; k <= 10; k++) {
            if (k == 5) return;
            sum = sum + k;
        }
    }
}
