package stream;

import java.util.Arrays;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        int sumValue = Arrays.stream(arr).sum();
        System.out.println(sumValue);
        int count =(int)Arrays.stream(arr).count();
        System.out.println(count);
        Arrays.stream(arr)
                .sorted()
                .forEach(x -> System.out.println(x));
    }
}
