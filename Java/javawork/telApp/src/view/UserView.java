package view;

import dto.TelDto;
import exception.InputValidation;
import exception.MyException;
import service.TelBookService;

import javax.xml.stream.events.DTD;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner sc = new Scanner(System.in);
    TelBookService service = new TelBookService();
    InputValidation validation = new InputValidation();

    public void searchAll(){
        List<TelDto> dtoList = new ArrayList<>();
        dtoList = service.getListAll();
        if(dtoList.isEmpty()){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        } else {
            PrintTitle.line();
            PrintTitle.title();
            PrintTitle.line();
            for(TelDto dto : dtoList){
                System.out.println(dto);
            }
            PrintTitle.line();
        }
    }

    public void insert() throws Exception{
        String name = null;
        int age = 0;
        String address = null;
        String telNumber = null;

        // 이름 입력
        System.out.println("======= 전화번호 등록 ========");
        boolean checkName = true;
        do{
            try {
                System.out.println("이름 : ");
                name = sc.next();
                validation.nameCheck(name);
                checkName = false;
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } while (checkName);

        // 나이 입력
        boolean checkAge = true;
        do{
            try {
                System.out.println("나이 : ");
                age = sc.nextInt();
                validation.ageCheck(age);
                checkAge = false;
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } while (checkAge);

        System.out.println("주소 : ");
        address = sc.next();

        // 나이 입력
        boolean checkTelNumber = true;
        do{
            try {
                System.out.println("전화번호 : ");
                telNumber = sc.next();
                validation.phoneCheck(telNumber);
                checkTelNumber = false;
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } while (checkTelNumber);

        //받은 데이터를 데이터베이스에 저장하는 메서드를 호출
        int result = service.insertData(TelDto.of(name,age,address,telNumber));
        if(result != 0){
            System.out.println();
            System.out.println("####### 성공적으로 입력 되었습니다. #######");
            System.out.println();
        }
    }
}
