package stream;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tomas");
        list.add("Adward");
        list.add("jack");
        // 리스트 내용 출력하기
        list.stream().forEach(o -> System.out.println(o));
        System.out.println("-------------------------");
        // 리스트 내용을 정렬해서 출력
        list.stream().sorted().forEach(x -> System.out.println(x));
        System.out.println("-------------------------");
        // 리스트 내용의 각 길이를 출력
        list.stream().map(x -> x.length()).forEach(x-> System.out.printf(x + " "));
        System.out.println();
        System.out.println("-------------------------");
        // 리스트의 길이가 5 이상인 자료를 오름차순 정렬로 보고 싶어요
        list.stream()
                .filter(x -> x.length()>=5)
                .sorted()
                .forEach(x -> System.out.println(x));
        // 정수리스트 처리
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        // 합계 출력
        int sum = intList.stream()
                .mapToInt(n -> n.intValue())
                .sum();
        System.out.println("리스트 합계 : " + sum);
    }
}
