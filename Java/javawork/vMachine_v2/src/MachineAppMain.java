import service.InitClazz;
import service.ManagerServiceImpl;
import service.UserServiceImpl;
import vo.ProductVO;

import java.util.Scanner;

public class MachineAppMain {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ManagerServiceImpl managerService = new ManagerServiceImpl();

        Scanner sc = new Scanner(System.in);

//        ProductVO product = new ProductVO("콜라", 1000,10);
//        InitClazz.lists.add(product);
//        InitClazz.printMenu();

        int ch = 0;
        while (true){
            do{
                System.out.println("1.동전투입  2.잔돈반환  3.메뉴선택  4.관리자 메뉴  5.종료=>");
                ch = sc.nextInt();
            } while (ch <1 || ch>5);
            if(ch == 5) break;

            switch (ch){
                case 1:
                    // 동전투입
                    userService.insertCoin();
                    break;
                case 2:
                    // 잔돈반환
                    userService.returnCoin();
                    break;
                case 3:
                    // 메뉴선택
                    System.out.println("메뉴선택");
                    userService.choiceMenu();
                    break;
                case 4:
                    // 관리자메뉴
                    while (true){
                        do{
                            System.out.println("1.메뉴등록  2.메뉴삭제  3.메뉴수정  4.재고등록" +
                                    "  5.전체목록보기  6.이전 =>");
                            ch = sc.nextInt();
                        }while (ch <1 || ch>6);
                        if(ch == 6) break;
                        switch (ch){
                            case 1:
                                managerService.enterMenu();
                                InitClazz.printMenu();
                                break;
                            case 2:
                                managerService.deleteMenu();
                                break;
                            case 3:
                                managerService.updateMenu();
                                break;
                            case 4:
                                managerService.enterStock();
                                break;
                            case 5:
                                System.out.println("전체목록보기");
                                InitClazz.printMenu();
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
