package stream;

import ch04.a.Cal;

public class LambdaExpressionTest {
    public static void main(String[] args) {
        Calc add = (x, y) -> {return x+y;};
        Calc minus = (a, b)-> a-b;
        Calc multy = (x, y)->{return x*y;};
        System.out.println(add.calc(3,4));
        System.out.println(minus.calc(10, 5));
        System.out.println(multy.calc(3,2));
    }
}
