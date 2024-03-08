package vendingMachineTest;

public class ColaVendingMachine {
    final String name = "콜라";
    int currentMoney = 0;  //투입금액
    int productPrice = 500; // 콜라 가격
    void insertMoney(int money){
        currentMoney = currentMoney + money;
        currentMoneyPrint();
    }
    void serveCola(){
        if(currentMoney < productPrice){
            System.out.println("잔액이 부족합니다.");
        } else {
            System.out.println(name + " 1개를 드립니다.");
            currentMoney = currentMoney - productPrice;
            currentMoneyPrint();
            VendingMachine.totalMoney = VendingMachine.totalMoney + productPrice;
        }
    }
    void currentMoneyPrint(){
        System.out.println("현재 잔액은 " + currentMoney + "입니다.");
    }
}
