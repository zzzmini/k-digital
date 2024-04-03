package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{

    @Override
    public String apply(String s1, String s2) {
        if(s1.length()>=s2.length()) {
            return s1;
        }
        else {
            return s2;
        }
    }
}

public class ReduceTest {
    public static void main(String[] args) {
        String[] message = {"안녕하세요",
                "hello", "반값습니다. 좋은 아침입니다.", "Good Morning~~"};
        String result;
        result = Arrays.stream(message).reduce("", (s1, s2) ->{
           if(s1.length() >= s2.length()) {
               return s1;
           } else {
               return s2;
           }
        });
        System.out.println(result);
        System.out.println("----------------------");
        result = Arrays.stream(message)
                .reduce(new CompareString())
                .get();
        System.out.println(result);
    }
}
