package quiz_02;

public class DiceProblem {
    final static int COUNT = 3000000;
    public static void main(String[] args) {
        // 결과를 담을 배열 선언
        int[] dice = new int[11];
        // 36,000번 돌리기
        // 상수 선언하기

        for (int i = 1; i < DiceProblem.COUNT;i++) {
            // 두개 주사위 생성
            int dice01 = (int)(Math.random()*6) + 1;
            int dice02 = (int)(Math.random()*6) + 1;
            int sum = dice01 + dice02;
            dice[sum -2] ++;
        }
        // 결과 출력
        System.out.println("Output :");
        for (int i = 0; i < dice.length; i++) {
            double rate = (double) dice[i] / DiceProblem.COUNT;
            String strRate = String.format("%7.6f", rate);
            System.out.println((i + 2) + " : " + dice[i] + "(" + strRate +")");
        }
    }
}
