package streamTest;

import java.util.Arrays;

public class ReduceTest {
	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~", "hello", "Good morning", "반갑습니다."};
		
		String result;
		// 스트림으로 정렬
		Arrays.stream(greetings).sorted().forEach(x -> System.out.println(x));;
		
		// 람다식으로 reduce 구현하기 -> 가장 긴 글 또는 가장 짧은 글
		result = Arrays.stream(greetings).reduce("", (s1, s2) ->
		{
			if(s1.length() >= s2.length()) return s1;
			else return s2;
		});
		
		System.out.println("글자길이 오름차순");
		System.out.println(result);
		
		// BinaryOperator 를 활용 처리
		result = Arrays.stream(greetings)
				.reduce(new CompareString())
				.get();
		System.out.println(result);
	}
}






