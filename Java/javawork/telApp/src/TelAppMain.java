import db.DBConn;
import dto.TelDto;
import service.TelBookService;
import view.UserView;

import java.sql.Connection;
import java.util.Scanner;

public class TelAppMain {
    public static void main(String[] args) {
//        Connection conn = DBConn.getConnection();
        TelBookService service = new TelBookService();
        UserView userView = new UserView();

        Scanner sc = new Scanner(System.in);
        int ch = 0;
        while (true){
            do{
                System.out.println("1.입력 2.수정 3.삭제 4.전체출력 5.아이디검색 6.종료");
                System.out.println("================================================");
                ch = sc.nextInt();
            } while (ch < 0 || ch > 6);
            switch (ch){
                case 1:
                    try {
                        userView.insert();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
//                    int result;
//                    System.out.println("1.입력");
//                    TelDto dto = new TelDto();
//                    dto.setName("김형민");
//                    dto.setAge(30);
//                    dto.setAddress("일산");
//                    dto.setTelNum("010-1111-1111");
//                    result = service.insertData(dto);
                    break;
                case 2:
                    userView.update();
                    break;
                case 3:
                    userView.delete();
                    break;
                case 4:
                    userView.searchAll();
                    break;
                case 5:
                    userView.searchOne();
                    break;
                case 6:
                    DBConn.close();
                    System.exit(0);
            }
        }
    }
}
