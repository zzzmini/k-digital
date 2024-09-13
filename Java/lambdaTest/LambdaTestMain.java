package lambdaTest;

public class LambdaTestMain {
	public static void main(String[] args) {
		Calc add = (x, y) -> {
			return x + y;
		};
		Calc minus = (x, y) -> x - y;

		System.out.println(add.calc(3, 2));
		System.out.println(minus.calc(5, 4));
		
		
		System.out.println("============");
		MaxNumTest maxNum = (a, b) -> {
			if(a > b) {
				return a;
			} else {
				return b;
			}
		};
		System.out.println("Max = " +  maxNum.maxOrMinNum(7, 8));
		
		MaxNumTest minNum = (x, y) -> x < y ? x : y;
		System.out.println("Min = " +  minNum.maxOrMinNum(7, 8));
	}
	
}
