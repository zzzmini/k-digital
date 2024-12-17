package lambda;

public class LambdaExpression {
    public static void main(String[] args) {
        // 자바스크립트 : =>
        Calc add = (x, y) -> {
            return  x+y;
        };
        Calc minus = (x, y) -> x - y;

        System.out.println(add.calculator(3, 4));
        System.out.println(minus.calculator(7, 3));
    }
}
