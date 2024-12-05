package basic.baseballgame;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 정답이 들어갈 배열
        int[] result = new int[3];
        // 게이머가 입력한 값을 갖을 배열
        int[] input = new int[3];

        // 열번 기회주기

        // 1. 세자리 서로 다른 수를 생성
        createGame(result);
        String yesOrNo = "";
        while (! yesOrNo.equalsIgnoreCase("Y")) {
            // 2. 사용자에게 서로다른 3개 숫자를 입력 받아요
            //  235----> 배열에 쪼개 넣어야지요
            for (int i = 1; i <= 10; i++) {
                inputData(input);
                // 3. 이제 맞는지 검사
                boolean check = checkValue(result, input);
                if (check == true) {
                    System.out.println("정답입니다.");
                    break;
                }
            }
            System.out.println("게임을 종료 하겠습니까(Y/N)");
            yesOrNo = sc.next();
        }
    }

    private static boolean checkValue(int[] result, int[] input) {
        // 정답 확인
        // 1. 스트라이크 갯수 구하기
        // 2. 볼 갯수 구하기
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if(input[i] == result[j]) {
                        strike++;
                        break;
                    }
                } else {
                    if(input[i] == result[j]) {
                        ball++;
                        break;
                    }
                }
            }
        }
        System.out.println("strike : " + strike + ", ball : " + ball);
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    private static void inputData(int[] input) {
        System.out.println("서로다른 번호 3자리 입력 : ");
        String[] data = sc.next().split("");
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(data[i]);
        }
        System.out.println("내 숫자 : " + Arrays.toString(input));
    }

    // 세자리 다른 정수 값 생성하기(정답용)
    private static void createGame(int[] result) {
        int num = 0;
        int count = 0;
        // 전체 배열을 -1로 초기화
        for (int i = 0; i < 3; i++) {
            result[i] = -1;
        }

        boolean flag = false;  // 중복검사용
        while (count <= 2) {
            num = (int) (Math.random() * 10);
            for (int i = 0; i <= count; i++) {
                if(num == result[i]) flag = true;
            }
            if (flag == false) {
                result[count] = num;
                count++;
            } else {
                flag = false;
            }
        }
        System.out.println("정답 : " + Arrays.toString(result));
    }
}
