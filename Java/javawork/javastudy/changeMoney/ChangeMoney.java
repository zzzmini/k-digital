package changeMoney;

public class ChangeMoney {
    static void exchageMoney(int currentMoney){
        System.out.println("5만원 : " + currentMoney/50000 + "장");
        currentMoney = currentMoney % 50000;
        System.out.println("1만원 : " + currentMoney/10000 + "장");
        currentMoney = currentMoney % 10000;
        System.out.println("1천원 : " + currentMoney/1000 + "장");
        currentMoney = currentMoney % 1000;
        System.out.println("5백원 : " + currentMoney/500 + "장");
        currentMoney = currentMoney % 500;
        System.out.println("1백원 : " + currentMoney/100 + "장");
    }
    public static void main(String[] args) {
        int currentMoney = 135200;
        exchageMoney(currentMoney);
    }
}
