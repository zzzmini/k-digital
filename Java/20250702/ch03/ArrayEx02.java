package ch03;

public class ArrayEx02 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("배열의 크기 : " + numbers.length);

        // 향상된 기능의 for
        for (int value : numbers) {
            System.out.println(value);
        }
    }
}
