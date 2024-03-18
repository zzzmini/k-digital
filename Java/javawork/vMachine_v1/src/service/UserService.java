package service;

import init.InitClass;
import view.UserView;

import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);

    public void menuView(){
        System.out.println("자판기입니다.(번호:상품(가격)-재고)");
        //번호:메뉴(가격)-재고출력
        for(int i=0; i<InitClass.MAX ; i++){
            if(InitClass.product[i] != null){
                System.out.print((i+1)+":"+InitClass.product[i]+"("+InitClass.price[i]+"W)-"+InitClass.stock[i]+"개 ");
                InitClass.productCount = i;
            }
        }
        System.out.println();
    }
//    메뉴선택 - 제품받기
    public void outProduct(int num){
        UserView.money = UserView.money - InitClass.price[num];
        InitClass.stock[num] --;
        InitClass.profit += InitClass.price[num];
        System.out.println(InitClass.product[num]+"이(가) 나왔다!");
    }
//    금액추가
    public void addMoney(){
        System.out.print("돈을 넣어주세요:");
        int extra = sc.nextInt();
        UserView.money += extra;
        System.out.println("금액이 추가 되었습니다! 잔액:"+UserView.money);
    }
//    잔돈반환
    public void returnMoney(){
        System.out.println("거스름 돈"+ UserView.money+"원이 반환 됩니다.");
        System.out.println("감사합니다! 다음에 또 이용해주세요!!");
    }
}
