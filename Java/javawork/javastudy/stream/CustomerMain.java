package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        Customer lee = new Customer("이순신", 40, 100);
        Customer kim = new Customer("김유신", 20, 100);
        Customer hong = new Customer("홍길동", 13, 50);

        List<Customer> list = new ArrayList<>();
        list.add(lee);
        list.add(kim);
        list.add(hong);

        System.out.println("1. 고객명단에 추가된 순서대로 출력");
        list.stream()
                .forEach(x -> System.out.println(x));
        System.out.println("------------------------------------------");

        System.out.println("2. 고객명단 중 이름만 출력");
        list.stream()
                .map(c -> c.getName())
                .forEach(c -> System.out.printf(c + " "));
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("3. 총 여행경비 출력하기");
        int totalPrice = list.stream()
                .mapToInt(x -> x.getPrice())
                .sum();
        System.out.println("총 여행경비는 : " + totalPrice);
        System.out.println("------------------------------------------");
        System.out.println("4. 20세 이상 고객의 이름을 오름차순으로 출력");
        list.stream()
                .filter(x -> x.getAge()>=20)
                .map(x -> x.getName())
                .sorted()
                .forEach(x -> System.out.println(x));
        System.out.println("------------------------------------------");
        System.out.println("5. 20세 이상 고객 전체를 이름에 대해 내림차순으로 출력");
        list.stream()
                .filter(y -> y.getAge()>=20)
                .sorted(Comparator.comparing(Customer::getName).reversed())
                .forEach(y -> System.out.println(y));
    }
}
