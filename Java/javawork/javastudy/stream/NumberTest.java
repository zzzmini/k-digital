package stream;

public class NumberTest {
    public static void main(String[] args) {
        MaxOrMin maxNumber = (x, y)->{
            if(x > y){
                return x;
            } else {
                return y;
            }
        };
        MaxOrMin minNumber = (x, y) -> x < y? x: y;

        System.out.println("Max = " + maxNumber.maxOrMinValue(20,10));
        System.out.println("Min = " + minNumber.maxOrMinValue(20, 10));
    }
}
