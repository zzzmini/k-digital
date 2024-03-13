package ch06.quiz;

import java.util.Random;
import java.util.Scanner;

public class JuminTest {
    public static void main(String[] args) {
        int[] intJumin = new int[13];  // 주민번호 계산용
        int result = 0;  // 중간계산값 저장용도
        String[] strJumin = new String[13];  // scanner 입력 보관용
//        String value = "123";
//        int result = Integer.parseInt(value) + 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하세요");
        String jumin = sc.next();
        strJumin = jumin.split("");
        for(int i=0; i<intJumin.length; i++){
             if(i <=7){
                 intJumin[i] = Integer.parseInt(strJumin[i]);
                 result = result + (intJumin[i] * (i + 2));
             } else if(i>7 && i<12){
                 intJumin[i] = Integer.parseInt(strJumin[i]);
                 result = result + (intJumin[i] * (i - 6));
             } else {
                 intJumin[i] = Integer.parseInt(strJumin[i]);
             }
        }
        result = result % 11;
        result = 11 - result;
        result = result % 10;
        if(result == intJumin[intJumin.length - 1]){
            System.out.println("옳바른 주민번호입니다.");
        } else {
            System.out.println("잘못된 주민번호입니다.");
        }
    }
}
