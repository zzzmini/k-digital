package exceptionTest;

public class ExceptionTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누면 미워요");
        } catch (Exception e) {
            System.out.println("예외가 발생했어요");
        } finally {
            System.out.println("여기는 무조건 실행되요");
        }
    }
}
