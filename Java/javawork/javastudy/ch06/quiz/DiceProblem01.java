package ch06.quiz;

import java.util.Random;

public class DiceProblem01 {
    public static void main(String[] args) {
        Random random = new Random();
        final int COUNT = 30000;
        int[] diceNum = new int[6];
        for(int i = 1; i <= COUNT; i++){
            int num = (random.nextInt(6) + 1);  //3이 나오면
            diceNum[num - 1] = diceNum[num - 1] +1;
        }
        for(int i=0; i < diceNum.length; i++){
            System.out.println(i + 1 + "번 눈의 출현확률 : " +
                    String.format("%.6f",(double)diceNum[i]/COUNT));
        }
    }
}
