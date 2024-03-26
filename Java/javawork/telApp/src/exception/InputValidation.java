package exception;

import java.util.regex.Pattern;

public class InputValidation {
    //이름 확인
    public void nameCheck(String name) throws MyException{
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if(! check){
            throw new MyException("이름은 한글로 입력해 주세요.");
        }
    }


    // 나이를 체크하는 기능
    public void ageCheck(int age) throws MyException{
        if(age<0 || age>120)
            throw new MyException("나이는 0세부터 120세 까지 입니다.");
    }
    // 전화번호 확인
    public void phoneCheck(String phone) throws MyException{
        boolean check = Pattern.matches(
                "(010)-(\\d{3,4})-(\\d{4})", phone);
        if(! check){
            throw new MyException("휴대폰 입력형식은 [010-xxxx-xxxx]입니다.");
        }
    }
}
