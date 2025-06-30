package ch02;

public class WhileTest {
    public static void main(String[] args) {
        // 1 ~ 10까지 더하는 과정을
        // while 구문으로 표기
        // for(int i = 1; i <= 10; i ++){sum = sum + i;}
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum = sum + i;
            i = i + 1;
        }
        System.out.println(sum);
        System.out.println(i);
        // 초기화
        sum = 0;
        i = 1;
        // do ~ while 구문
        do {
            sum = sum + i;
            i = i + 1;
        } while (i <= 10);
        System.out.println(sum);
    }
}
