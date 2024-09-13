package streamTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStreamTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Tomas");
		list.add("Adward");
		list.add("Jack");
		
		// 리스트 내용 출력하기
		list.stream().forEach(str -> System.out.println(str));
		
		// 리스트 내용을 정렬하여 출력
		System.out.println("정렬 후 출력");
		list.stream()
			.sorted()
			.forEach(x -> System.out.println(x));
		
		// 리스트 내용의 길이 출력하기
		System.out.println("내용의 길이 출력하기");
		list.stream().map(x -> x.length())
			.forEach(str -> System.out.println(str));
		// 문자열 길이가 5 이상인 자료를 정렬해서 출력.
		list.stream().filter(x -> x.length() >= 5)
				.sorted()
				.forEach(x -> System.out.print(x + "\t"));
		
		// 정수 처리
		System.out.println("===== 정수처리");
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++) {
			intList.add(i);
		}
		
		// 전체 출력하기(tab으로 구분해서)
		intList.stream().forEach(x -> System.out.printf(x + "\t"));
		// 합계출력
		System.out.println();
		int sumValue = intList.stream().mapToInt(x -> x.intValue()).sum();
		System.out.println("숫자 합계 출력 = "  + sumValue);
	}
}







