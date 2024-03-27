package view;

import dto.TelDto;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    public void insertView() {
        String name = null;
        int age = 0;
        String addr = null;
        String telNum = null;
        System.out.println("신규 데이터를 입력합니다.");
        System.out.println("이름 : ");
        name = sc.next();
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("주소 : ");
        addr = sc.next();
        System.out.println("전화번호 : ");
        telNum = sc.next();
        TelDto dto = TelDto.of(name,age,addr,telNum);
        int result = userService.insertData(dto);
        if(result != 0){
            System.out.println("데이터 입력 성공!!!");
        } else {
            System.out.println("입력에 실패했습니다.");
        }
    }

    public void updateView() {
        TelDto dto = null;
        int id = 0;
        String name = null;
        int age = 0;
        String addr = null;
        String tel = null;

        System.out.println("수정할 ID를 입력하세요.");
        // id 존재 유무 검색
        id = sc.nextInt();
        dto = userService.selectOne(id);
        if(dto == null){
            System.out.println("찾는 ID가 없습니다.");
            return;
        } else {
            // 수정작업
            System.out.println("변경 전 이름 : " + dto.name());
            name = dto.name();
            name = sc.next();

            System.out.println("변경 전 나이 : " + dto.age());
            age = dto.age();
            age = sc.nextInt();

            System.out.println("변경 전 주소 : " + dto.addr());
            addr = dto.addr();
            addr = sc.next();

            System.out.println("변경 전 전화번호 : " + dto.tel());
            tel = dto.tel();
            tel = sc.next();
            // 수정데이터를 dto에 담는다.
            dto = TelDto.allOf(id, name, age, addr, tel);
            // 데이터를 수정하러 서비스를 호출
            int result = userService.updateData(dto);
            // 수정 성공 or 실패 처리하기
            if(result != 0){
                System.out.println("정상적으로 수정되었습니다.");
            } else {
                System.out.println("수정에 실패했습니다.");
            }
        }
    }

    public void deleteView() {
        int id;
        String yesOrNo;
        System.out.println("삭제할 ID를 입력하세요");
        id = sc.nextInt();
        TelDto dto = userService.selectOne(id);
        if(dto == null){
            System.out.println("해당 ID는 존재하지 않습니다.");
            return;
        } else {
            // 삭제 여부 확인하고 처리하기
            do{
                System.out.println("정말로 삭제할거니?(Y/N)");
                yesOrNo = sc.next();
            } while (!(yesOrNo.toUpperCase().equals("Y")||yesOrNo.toUpperCase().equals("N")));
            if(yesOrNo.toUpperCase().equals("Y")){
                // 진짜로 삭제처리하기
                int result = userService.deleteData(id);
                if(result != 0){
                    System.out.println("정상적으로 삭제 되었습니다.");
                    return;
                } else {
                    System.out.println("삭제에 실패했습니다.");
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void showAllView() {
        List<TelDto> list = new ArrayList<>();
        list = userService.showAllData();
        if(list.isEmpty()){
            System.out.println("자료가 없습니다.");
            return;
        } else {
            for(TelDto dto : list){
                System.out.println(dto);
            }
        }
    }

    public void showOneView() {
        int id;
        System.out.println("검색할 ID 입력 : ");
        id = sc.nextInt();
        TelDto dto = userService.selectOne(id);
        if(dto == null){
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            System.out.println(dto);
        }
    }
}
