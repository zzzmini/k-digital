package vendingMachineTest;

public class VendingMachine {
    static int totalMoney = 0;
    public static void main(String[] args) {
        VMachine colaMachine = new VMachine();
        VMachine cyderMachine = new VMachine();

        colaMachine.name = "콜라";
        colaMachine.productPrice = 600;
        colaMachine.insertMoney(1000);
        colaMachine.serveProduct();
        System.out.println("현재 수익은 : " + totalMoney);

        cyderMachine.name = "사이다";
        cyderMachine.productPrice = 900;
        cyderMachine.insertMoney(2000);
        cyderMachine.serveProduct();
        System.out.println("현재 수익은 : " + totalMoney);

//        ColaVendingMachine colaVendingMachine = new ColaVendingMachine();
//        CyderVendingMachine cyderVendingMachine = new CyderVendingMachine();
//
//        colaVendingMachine.insertMoney(1000);
//        colaVendingMachine.insertMoney(500);
//        colaVendingMachine.serveCola();
//        System.out.println("현재 수익은 : " + totalMoney);
//        colaVendingMachine.serveCola();
//        System.out.println("현재 수익은 : " + totalMoney);
//
//        cyderVendingMachine.insertMoney(800);
//        cyderVendingMachine.serveCola();
//        System.out.println("현재 수익은 : " + totalMoney);
    }
}
