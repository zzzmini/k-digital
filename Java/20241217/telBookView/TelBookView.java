package telBookView;

import dto.InitData;
import dto.TelBookDto;
import telBookService.TelBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelBookView {
    TelBookService service = new TelBookService();
    Scanner sc = new Scanner(System.in);

    public void inputView() {
        String name;
        int age;
        String address;
        String phone;
        System.out.println("💾 데이터를 입력하는 화면입니다.");
        System.out.println("✏ 이름 :");
        name = sc.next();
        System.out.println("✏ 나이 :");
        age = sc.nextInt();
        System.out.println("✏ 주소 :");
        address = sc.next();
        System.out.println("✏ 전화번호 :");
        phone = sc.next();
        // 입력받은 데이터로 DTO 생성
        int result = service.input(
                new TelBookDto(InitData.id, name, age, address, phone));
        if (result == 1) {
            System.out.println("데이터 입력 성공");
        } else {
            System.out.println("입력 실");
        }
    }

    public void printAll() {
        List<TelBookDto> list = new ArrayList<>();
        printLine();
        printTitle();
        // 전체 데이터 출력
        list = service.getAllList();
        if (list.size() == 0) {
            System.out.println("데이터가 없습니다.");
        } else {
            //출력
            for (TelBookDto x : list) {
                System.out.println(x);
            }
        }
        printLine();
    }

    public void printLine() {
        System.out.println("==========================================");
    }
    public void printDashLine() {
        System.out.println("---------------------------------------------------------------------------");
    }

    public void printTitle() {
        System.out.println("ID      이름          나이          주소             전화번호");
    }

    public void deleteView() {
        System.out.println(" 데이터를 삭제하는 화면입니다.");
        System.out.println("✏ 삭제할 아이디를 입력하세요.");
        int deleteId = sc.nextInt();
        int result = service.deleteId(deleteId);
        if (result == 1) {
            System.out.println("삭제성공");
        } else {
            System.out.println("삭제 실");
        }
    }

    public void updateView() {
        String name = "";
        int age = 0;
        String address = "";
        String telNum = "";

        System.out.println("📌수정할 아이디를 입력하세요");
        int updateId = sc.nextInt();
        TelBookDto dto = service.findById(updateId);
        if(dto == null) return;

        System.out.println("💾 저장된 이름 : " + dto.getName());
        while (true) {
            System.out.println("📌 수정하시겠습니까?(Y/N)");
            String yesOrNo = sc.next();
            if (yesOrNo.toUpperCase().equals("Y")) {
                System.out.println("🏷 수정할 이름 : ");
                name = sc.next();
                dto.setName(name);
                break;
            } else if (yesOrNo.toUpperCase().equals("N")) {
                break;
            }
        }

        System.out.println("💾 저장된 나이 : " + dto.getAge());
        while (true) {
            System.out.println("📌 수정하시겠습니까?(Y/N)");
            String yesOrNo = sc.next();
            if (yesOrNo.toUpperCase().equals("Y")) {
                System.out.println("🏷 수정할 나이 : ");
                age = sc.nextInt();
                dto.setAge(age);
                break;
            } else if (yesOrNo.toUpperCase().equals("N")) {
                break;
            }
        }
        System.out.println("💾 저장된 주소 : " + dto.getAddress());
        while (true) {
            System.out.println("📌 수정하시겠습니까?(Y/N)");
            String yesOrNo = sc.next();
            if (yesOrNo.toUpperCase().equals("Y")) {
                System.out.println("🏷 수정할 주소 : ");
                address = sc.next();
                dto.setAddress(address);
                break;
            } else if (yesOrNo.toUpperCase().equals("N")) {
                break;
            }
        }
        System.out.println("💾 저장된 전화번호 : " + dto.getTelNum());
        while (true) {
            System.out.println("📌 수정하시겠습니까?(Y/N)");
            String yesOrNo = sc.next();
            if (yesOrNo.toUpperCase().equals("Y")) {
                System.out.println("🏷 수정할 전화번호 : ");
                telNum = sc.next();
                dto.setTelNum(telNum);
                break;
            } else if (yesOrNo.toUpperCase().equals("N")) {
                break;
            }
        }
        // 수정 요청하기
        int result = service.update(dto);
        if (result == 1) {
            System.out.println("👍 수정이 완료되었습니다.");
        } else {
            System.out.println("수정실");
        }
    }

    public void searchNameView() {
        List<TelBookDto> list = new ArrayList<>();
        System.out.println("👓 데이터를 검색하는 화면입니다.");
        System.out.println("✏ 검색할 이름을 입력하세요.");
        String searchName = sc.next();
        list = service.searchName(searchName);
        if (list.size() == 0) {
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            printLine();
            printTitle();
            for (TelBookDto dto : list) {
                System.out.println(dto);
                printDashLine();
            }
            printLine();
        }
    }
}
