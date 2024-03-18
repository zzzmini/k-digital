import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // 초기값들 정리
    static Scanner sc = new Scanner(System.in);
    static final int MAX = 5;   // 최대 취급 제품 수
    static String[] product = new String[MAX];  // 제품배열
    static int[] price = new int[MAX];  // 가격배열
    static int[] stock = new int[MAX];  // 재고 수량 배열
    static int currentMoney = 0;  //사용자가 넣은 돈
    static int profit = 0; // 관리자의 총 수익 계산 용 변수
    static int productCount = 3;

    public static void initialize(){
        product[0] = "콜라";
        price[0] = 500;
        stock[0] = 3;
        product[1] = "사이다";
        price[1] = 700;
        stock[1] = 4;
        product[2] = "커피";
        price[2]= 1500;
        stock[2] = 5;
    }

    public static void user(){
        Boolean first = true;
        int money = 0;
        while(true){
            System.out.println("==================================================");
            System.out.println("자판기입니다.(번호:상품(가격)-재고)");
            //번호:메뉴(가격)-재고출력
            for(int i=0; i<MAX ; i++){
                if(product[i] != null){
                    System.out.print((i+1)+":"+product[i]+"("+price[i]+"W)-"+stock[i]+"개 ");
                    productCount = i;
                }
            }
            System.out.println();
            System.out.println("==================================================");

            //처음에만돈을입력받고잔돈반환전까지는돈을입력받지않는다.
            if(first){
                System.out.print("돈을 넣어주세요:");
                money = sc.nextInt();
                first = false;
            }
            //관리자비밀번호는1004,입력하면관리자함수로넘어감.
            if(money==1004){
                admin();
                return;
            }
            System.out.print("메뉴입력:");
            int num=sc.nextInt();
            //돈이 충분한가?
            if(money>=price[num-1]){
                //재고가 충분한가?
                if(stock[num-1]>0){
                    money = money - price[num-1];
                    stock[num-1] --;
                    profit += price[num-1];
                    System.out.println(product[num-1]+"이(가) 나왔다!");
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
                System.out.print("돈을 넣어주세요:");
                int extra = sc.nextInt();
                money += extra;
                System.out.println("금액이 추가 되었습니다! 잔액:"+money);
            }
            else if(num1==3){
                System.out.println("거스름 돈"+money+"원이 반환 됩니다.");
                System.out.println("감사합니다! 다음에 또 이용해주세요!!");
                first = true;
            }
        }
    }


    public static void admin(){
        while (true){
            System.out.println("==================================================");
            System.out.println("관리자 페이지입니다.");
            System.out.println("1:메뉴변경 2:가격변경 3:재고추가 4:메뉴추가 5:수익확인(종료는 -1)");

            System.out.print("번호를 입력하세요:");
            int num = sc.nextInt();
            System.out.println("==================================================");
            //1.메뉴변경
            if(num==1){
                System.out.print("변경하실 메뉴의 번호를 입력하세요(1~"+(productCount+1)+"):");
                int i = sc.nextInt();
                System.out.print(product[i-1]+"를(을) 무엇으로 바꾸시겠습니까?:");
                sc.nextLine();
                String name=sc.next();
                System.out.print(name+"의 가격은 얼마입니까?");
                int v = sc.nextInt();
                System.out.print(name+"의 재고를 몇 개 등록 하시겠습니까?:");
                int n = sc.nextInt();
                product[i-1]=name;
                price[i-1]=v;
                stock[i-1]=n;
                System.out.println("메뉴 변경이 완료되었습니다!");
            }
            //2.가격변경
            else if(num==2){
                System.out.print("가격을 변경하실 메뉴의 번호를 입력하세요(1~"+(productCount+1)+"):");
                int i = sc.nextInt();
                System.out.print(product[i-1]+"의 가격을 얼마로 바꾸시겠습니까?:");
                int j = sc.nextInt();
                price[i-1]=j;
                System.out.println("가격 변경이 완료 되었습니다!");
            }
            //3.재고추가
            else if(num==3){
                System.out.print("재고를 추가하실 메뉴의 번호를 입력하세요(1~"+(productCount+1)+"):");
                int i = sc.nextInt();
                System.out.print(product[i-1]+"를(을) 몇 개 추가 하시겠습니까?:");
                int j = sc.nextInt();
                stock[i-1]+=j;
                System.out.println("재고 추가가 완료 되었습니다!");
            }
            //4.메뉴추가
            else if(num==4){
                if(productCount == (MAX-1)){
                    System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다!");
                    continue;
                }
                else{
                    System.out.print("추가하실 메뉴의 가격을 입력하세요:");
                    int i =sc.nextInt();
                    System.out.print("추가하실 메뉴의 이름을 입력하세요:");
                    sc.nextLine();
                    String name = sc.next();
                    System.out.print(name+"의 재고는 몇 개 입니까?:");
                    int j =sc.nextInt();
                    product[productCount+1]=name;
                    price[productCount+1]=i;
                    stock[productCount+1]=j;
                    productCount++;
                    System.out.println("메뉴 추가가 완료 되었습니다!");
                }
            }
            //5.수익확인
            else if(num==5){
                System.out.println("현재까지의 수익은"+profit+"입니다.");
            }
            //-1을입력하면다시자판기메뉴로돌아감
            else if(num==-1){
                user();
                return;
            }
        }
    }

    public static void main(String[] args) {
        initialize();
        user();
    }
}