package telBookApp.exception;

import java.util.regex.Pattern;

public class InputValidation {
	// 이름확인 - 한글만...
	public void nameCheck(String name) throws MyException{
		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
		if(! check) {
			throw new MyException("* 이름은 한글로 입력해 주세요");
		}
	}
	// 전화번호 양식일치하는 확인
	public void phoneCheck(String phone) throws MyException{
		boolean check = Pattern
				.matches("^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$", phone);
		if(! check) {
			throw new MyException("* 전화번호 형식은 [xxx-xxxx-xxxx]입니다.");
		}
	}
	
	// 나이가 1세~120세 사이 값인지 확인
	public void ageCheck(int age) throws MyException{
		if(age < 0 || age > 120) {
			throw new MyException("* 나이는 1세부터 120세 까지 입니다.");
		}
	}
}






