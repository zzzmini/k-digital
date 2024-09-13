package streamTest;

import java.util.Arrays;

public class IntegerArrayTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,};
		int intSumValue = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		
		System.out.println("배열의 합 : " + intSumValue);
		System.out.println("배열의 갯수 : " + count);
		
		for(int x : arr) {
			System.out.println(x);
		}
		System.out.println("=============");
		Arrays.stream(arr).forEach(x -> System.out.println(x));
	}
}







