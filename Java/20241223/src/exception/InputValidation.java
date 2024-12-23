package exception;

import java.util.regex.Pattern;

public class InputValidation {
    // 이름확인 - 한글만 가능하도록
    public boolean nameCheck(String name) throws MyException {
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if (! check) {
            throw new MyException("※ 이름은 한글로 입력해 주세요!!");
        }
        return (!check);
    }

    // 전화번호 타입 확인(휴대전화)
    public boolean phoneCheck(String phone) throws MyException {
        boolean check = Pattern.matches("^010-?([0-9]{4})-?([0-9]{4})$", phone);
        if (! check) {
            throw new MyException("※ 휴대폰 입력 형식은 : [010-XXXX-XXXX] 입니다.");
        }
        return (!check);
    }

    // 나이 입력 확인
    public boolean ageCheck(int age) throws MyException {
        if (age < 0 || age > 120) {
            throw new MyException("※ 나이는 0세부터 120세 까지 입니다.");
        } else {
            return false;
        }
    }
}
