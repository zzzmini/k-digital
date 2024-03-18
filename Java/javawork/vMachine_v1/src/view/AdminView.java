package view;

import init.InitClass;
import service.AdminService;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    AdminService adminService = new AdminService();
//    UserView userView = new UserView();
    public void adminView(){
        while (true){
            InitClass.line();
            System.out.println("관리자 페이지입니다.");
            System.out.println("1:메뉴변경 2:가격변경 3:재고추가 4:메뉴추가 5:수익확인(종료는 -1)");

            System.out.print("번호를 입력하세요:");
            int num = sc.nextInt();
            InitClass.line();
            //1.메뉴변경
            if(num==1){
                adminService.updateMenu();
            }
            //2.가격변경
            else if(num==2){
                adminService.updatePrice();
            }
            //3.재고추가
            else if(num==3){
                adminService.updateStock();
            }
            //4.메뉴추가
            else if(num==4){
                if(InitClass.productCount == (InitClass.MAX-1)){
                    System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다!");
                    continue;
                }
                else{
                    adminService.addMenu();
                }
            }
            //5.수익확인
            else if(num==5){
                adminService.confirmProfit();
            }
            //-1을입력하면다시자판기메뉴로돌아감
            else if(num==-1){
//                userView.userView();
                return;
            }
        }
    }
}
