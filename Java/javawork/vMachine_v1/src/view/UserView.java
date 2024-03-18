package view;

import init.InitClass;
import service.UserService;
import java.util.Scanner;

public class UserView {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    AdminView adminView = new AdminView();
    public static int money = 0;
    public void userView(){

        Boolean first = true;

        while(true){
            InitClass.line();
            userService.menuView();
            InitClass.line();

            //처음에만돈을입력받고잔돈반환전까지는돈을입력받지않는다.
            if(first){
                System.out.print("돈을 넣어주세요:");
                money = sc.nextInt();
                first = false;
            }
            //관리자비밀번호는1004,입력하면관리자함수로넘어감.
            if(money==1004){
                adminView.adminView();
                userService.menuView();
            }
            System.out.print("메뉴입력:");
            int num = sc.nextInt();
            //돈이 충분한가?
            if(money>=InitClass.price[num-1]){
                //재고가 충분한가?
                if(InitClass.stock[num-1]>0){
                    // 제품을 받는 곳
                    userService.outProduct(num-1);
                }
                else{
                    System.out.println("현재 재고가 없습니다!");
                    continue;
                }
            }
            else{
                System.out.println("잔액이 부족합니다!");
            }
            System.out.println("잔액:"+money);
            //모든 돈을 사용하면 이용 종료 후 초기화면 진입
            if(money==0){
                System.out.println("감사합니다! 다음에 또 이용해 주세요!!");
                first = true;
                continue;
            }
            //돈이 남아 있다면 선택지를 준다.
            System.out.println("1:계속구매하기 2:금액추가하기 3:잔돈반환하기");
            System.out.print("번호를 입력하세요:");
            int num1 = sc.nextInt();
            if(num1==1){
                continue;
            }
            else if(num1==2){
                userService.addMoney();
            }
            else if(num1==3){
                userService.returnMoney();
                first = true;
            }
        }
    }
}
