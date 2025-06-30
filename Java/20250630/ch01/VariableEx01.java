package ch01;

public class VariableEx01 {
    public static void main(String[] args) {
//         ctrl + / : 주석생성
//         정수형 변수 선언하기
        int score = 50;
        System.out.println("나의 점수는 " + score);
        long valueA = 34;
        System.out.println("나의 허리둘레는 : " + valueA);
        int bigValue = 1_000_000;
        // 실수형 변수 선언하기
        double doubleValue = 3.4;
        System.out.println("실수 출력 : " + doubleValue);
        // 논리값 변수 선언하기
        boolean b1 = true;
        System.out.println("참 : " + b1);
        boolean b2 = false;
        // 문자열 변수 선언
        char c1 = '가';
        String name = "장원영";
        System.out.println(name.contains("원영"));
    }
}
