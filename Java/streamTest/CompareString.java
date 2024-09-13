package streamTest;

import java.util.function.BinaryOperator;

public class CompareString implements BinaryOperator<String>{
	@Override
	public String apply(String s1, String s2) {
		if(s1.length() >= s2.length()) return s1;
		else return s2;
	}
}
