package ch02;
import java.util.Scanner;
public class ConfirmGender {
    // 주민번호 뒷자리 첫 숫자를 입력하세요.
    // 1 또는 3 이면 : 남자
    // 2 또는 4 이면 : 여자
    // 5 이면 : 외국인
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 주민번호 뒷자리 첫 숫자를 입력받습니다.
        System.out.println("주민번호 뒷자리 첫 숫자를 입력하세요");
        int num = sc.nextInt();
        String result;
        // 비교를 해야...
        if (num == 1 || num == 3) {
            result = "남";
        } else if (num == 2 || num == 4) {
            result = "여";
        } else if (num == 5) {
            result = "외국인";
        } else {
            result = "잘못 입력했습니다.";
        }
        System.out.println(result);
    }
}
