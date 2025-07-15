package collectionTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> fruits = new
                HashSet<>(Arrays.asList("사과", "바나나"));
        //출력
        for (String x : fruits) {
            System.out.println(x);
        }

        System.out.println("=====");
        fruits.add("수박");
        fruits.add("사과");
        //출력
        for (String x : fruits) {
            System.out.println(x);
        }
    }
}
