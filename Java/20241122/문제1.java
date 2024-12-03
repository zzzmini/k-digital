package basic.exam;

import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class 문제1 {
    public static void main(String[] args) {
        // 1. 1부터 10까지 출력
        // 2. 6일 때 출력 제외
        for (int i = 1; i <= 10; i++) {
            if(i == 6) {
                continue;
            }
            System.out.println("i = " + i);
        }
        // while
        int j = 0;
        while (j < 10) {
            j ++;
            if(j == 6) {
                continue;
            }
            System.out.println("j = " + j);
        }
    }
}
