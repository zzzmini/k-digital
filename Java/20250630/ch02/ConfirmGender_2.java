package ch02;

import java.util.Scanner;

public class ConfirmGender_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 주민번호 뒷자리 첫 숫자를 입력받습니다.
        System.out.println("주민번호 뒷자리 첫 숫자를 입력하세요");
        int num = sc.nextInt();
        String result;
        // 비교를 해야...
        if (num < 1 || num > 5) {
            result = "잘 못 입력했어요";
        } else if (num == 5) {
            result = "외국인";
        } else if ((num % 2) == 1) {
            result = "남자";
        } else {
            result = "여자";
        }
        System.out.println(result);
    }
}
