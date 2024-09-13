package streamTest.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerMain {
	public static void main(String[] args) {
		Customer jang = new Customer("장원영", 20, 100);
		Customer ahn = new Customer("안유진", 20, 100);
		Customer hong = new Customer("홍길동", 40,50);
		
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(jang);
		customerList.add(ahn);
		customerList.add(hong);
		
		System.out.println("1. 고객 명단을 추가된 순서대로 출력하기");
		customerList.stream().forEach(x -> System.out.println(x));
		
		System.out.println("2. 고객 명단을 추가된 순서대로 이름만 출력하기");
		customerList.stream().map(x -> x.getName())
			.forEach(x -> System.out.println(x));
		
		System.out.println("3. 총 금액 출력하기");
		int sum = customerList.stream()
					.mapToInt(x -> x.getPrice()).sum();
		System.out.println("총 금액 : " + sum);
		System.out.println("4. 22세 이상 고객의 이름만 오름차순 출력하기");
		customerList.stream().filter(x -> x.getAge() >= 22)
			.map(x -> x.getName())
			.sorted()
			.forEach(x -> System.out.println(x));
		System.out.println("5. 20세 이상 고객 명단 전체 내림차순 출력하기");
		customerList.stream()
			.filter(x -> x.getAge() >= 20)
			.sorted(Comparator
					.comparing(Customer::getAge).reversed()
					.thenComparing(Customer :: getName)
					)
			.forEach(x -> System.out.println(x));
	}
}




