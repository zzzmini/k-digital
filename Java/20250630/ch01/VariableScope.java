package ch01;

// 요기 실행안됨
// 1. 클래스밖에 선언 안됨
//int a = 3;
public class VariableScope {
    static int b = 5;
    public static void main(String[] args) {
        // static -> main() 안에 있기 때문에
        // a 변수값을 사용할 수 있다.
        int a = 3;
        System.out.println("a = " + a);
        // b 출력
        System.out.println("b = " + VariableScope.b);
    }
}
