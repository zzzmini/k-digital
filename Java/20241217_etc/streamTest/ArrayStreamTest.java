package streamTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tomas");
        list.add("Adward");
        list.add("Jack");
        list.stream().forEach(x -> System.out.print(x + "\t"));
        System.out.println();
        //  리스트 내용 정렬해서 출력하기
        list.stream().sorted().forEach(name -> System.out.println(name));
        // 리스트 각 내용의 길이를 출력
        list
                .stream()
                .map(x -> x.length())
                .forEach(x -> System.out.println(x));
        // 문자열의 길이가 5이상인 자료만 출력
        list.stream()
                .filter(x -> x.length() >= 5)
                .sorted()
                .forEach(x -> System.out.println(x));

        // 정수 자료의 처리
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        // 전체 데이터 출력
        integerList.stream()
                .forEach(x -> System.out.println(x));
        // 합계출력
        int sumValue = integerList.stream()
                .mapToInt(x -> x.intValue())
                .sum();
        System.out.println("리스트의 합은 : " + sumValue);
    }
}
