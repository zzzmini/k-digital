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
    public void delete(){
        int id;
        System.out.println("삭제할 전화번호부의 ID : ");
        id = sc.nextInt();
        int result = service.deleteData(id);
        if(result != 0){
            System.out.println("ID : " + id + "의 자료가 삭제 되었습니다.");
        } else {
            System.out.println("자료 삭제에 실패하였습니다.");
        }
    }

    public void searchOne(){
        TelDto dto = null;
        System.out.println("검색 할 아이디 : ");
        int id = sc.nextInt();
        dto = service.searchOne(id);
        if(dto == null){
            System.out.println("검색한 데이터는 없습니다.");
        } else {
            PrintTitle.line();
            PrintTitle.title();
            PrintTitle.line();
            System.out.println(dto.toString());
            PrintTitle.line();
        }
    }

    public void update(){
        TelDto oldDto = null;
        String yesOrNo;
        int id;
        String name = null;
        int age = 0;
        String address = null;
        String telNumber = null;
        int result = 0;

        System.out.println("수정할 ID : ");
        id = sc.nextInt();
        oldDto = service.searchOne(id);
        if(oldDto == null) {
            System.out.println("해당하는 ID가 없습니다.");
            return;
        }

        System.out.println("기존 이름 : " + oldDto.getName());
        do {
            System.out.println("수정하겠습니까?(Y/N)");
            yesOrNo = sc.next();
        } while (!(yesOrNo.toUpperCase().equals("Y")||
                yesOrNo.toUpperCase().equals("N")));

        if(yesOrNo.toUpperCase().equals("Y")) {
            try {
                System.out.println("수정할 이름 : ");
                name = sc.next();
                validation.nameCheck(name);
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } else {
            name = oldDto.getName();
        }

        System.out.println("기존 나이 : " + oldDto.getAge());
        do {
            System.out.println("수정하겠습니까?(Y/N)");
            yesOrNo = sc.next();
        } while (!(yesOrNo.toUpperCase().equals("Y")||
                yesOrNo.toUpperCase().equals("N")));

        if(yesOrNo.toUpperCase().equals("Y")) {
            try {
                System.out.println("수정할 나이 : ");
                age = sc.nextInt();
                validation.ageCheck(age);
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } else {
            age = oldDto.getAge();
        }

        System.out.println("기존 주소 : " + oldDto.getAddress());
        do {
            System.out.println("수정하겠습니까?(Y/N)");
            yesOrNo = sc.next();
        } while (!(yesOrNo.toUpperCase().equals("Y")||
                yesOrNo.toUpperCase().equals("N")));

        if(yesOrNo.toUpperCase().equals("Y")) {
            System.out.println("수정할 주소 : ");
            address = sc.next();
        } else {
            address = oldDto.getAddress();
        }

        System.out.println("기존 전화번호 : " + oldDto.getTelNum());
        do {
            System.out.println("수정하겠습니까?(Y/N)");
            yesOrNo = sc.next();
        } while (!(yesOrNo.toUpperCase().equals("Y")||
                yesOrNo.toUpperCase().equals("N")));

        if(yesOrNo.toUpperCase().equals("Y")) {
            try {
                System.out.println("수정할 전화번호 : ");
                telNumber = sc.next();
                validation.phoneCheck(telNumber);
            } catch (MyException e) {
                System.out.println(e.toString());
            }
        } else {
            telNumber = oldDto.getTelNum();
        }

        result = service.updateData(TelDto.allOf(id,name,age,address,telNumber));

        if(result != 0){
            System.out.println("데이터를 수정하였습니다.");
        } else {
            System.out.println("데이터를 수정에 실패했습니다.");
        }
    }
}
