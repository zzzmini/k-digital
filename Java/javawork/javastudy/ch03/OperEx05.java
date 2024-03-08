package ch03;

public class OperEx05 {
    public static void main(String[] args) {
        // 삼항연산자 = 조건연산자
        int n1 = 5;
        // 조건? 참일때 : 거짓일때;
        System.out.println(n1==5? "5가 맞습니다.": "5가 아닙니다.");
        if(n1 == 5){
            System.out.println("5가 맞습니다.");
        } else {
            System.out.println("5가 아닙니다.");
        }
        int point = 59;
        System.out.println(point>=60 ? "Pass":"Fail");
        boolean passOrFail;
        passOrFail = point >= 60? true : false;
        if(passOrFail){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // 나머지 연산자 %
        System.out.println(130/100); // 몫 : 1
        System.out.println(130 % 100); // 나머지 : 30
    }
}
