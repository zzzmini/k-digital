package exception;

public class ExceptionTest {
    public static void divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("0으로 나누면 안되요!!!");
        }
        int c = a / b;
        System.out.println(c);
    }

    public static void main(String[] args) {
        int a;
        int b;
        a = 10;
        b = 0;
        try {
            divide(a, b);
        } catch (ArithmeticException e) {
//            e.getMessage();
            e.printStackTrace();
        }

//        try {
//            int c = a / b;
//            System.out.println(c);
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException 발생");
//            System.out.println("0 으로 나누면 안되요");
//        } finally {
//            System.out.println("무조건 실행");
//        }
    }
}
