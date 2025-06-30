package ch01;

public class ExchangeMoney {
    // 2,680원을 1,000원, 500원, 100원, 50원, 10원
    // 각각 몇 개씩 최소로 필요한지 출력하세요
    // 금액 : 2,680원
    // 1,000원 : 2 개
    // 500원 : 1 개
    // 100원 : 1 개
    // 50원 : 1 개
    // 10원 : 3 개
    public static void main(String[] args) {
        int coin = 2680;  // 초기 금액을 저장
        int restCoin = coin;

        System.out.println("바꿀 돈 : " + coin);

        // 1. 1000원
        restCoin = restCoinPrint(restCoin, 1000);

        // 2. 500원
        restCoin = restCoinPrint(restCoin, 500);

        // 3. 100원
        restCoin = restCoinPrint(restCoin, 100);

        // 4. 50원
        restCoin = restCoinPrint(restCoin, 50);

        // 5. 10원
        restCoin = restCoinPrint(restCoin, 10);
    }
    static int restCoinPrint(int restCoin, int don){
        System.out.println(don + "원 개수 : " + (restCoin / don));
        restCoin = restCoin % don;
        System.out.println("잔액 : " + restCoin);
        return restCoin;
    }
}
