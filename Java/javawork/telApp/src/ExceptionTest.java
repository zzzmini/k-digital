public class ExceptionTest {
    public static void divide(int a, int b) throws ArithmeticException{
        if(b==0) throw new ArithmeticException("0으로 나누면 안됨");
        int c = a / b;
        System.out.println(c);
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        try {
            divide(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("여기는 무조건 실행");
        }
    }
}
