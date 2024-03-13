package ch06.quiz;

import java.util.Random;

public class DiceProblem02 {
    public static void main(String[] args) {
        Random random = new Random();
        final int COUNT = 36000;
        int[] diceNum = new int[11];
        for(int i = 1; i <= COUNT; i++){
            int num1 = (random.nextInt(6) + 1);  //3이 나오면
            int num2 = (random.nextInt(6) + 1);  //3이 나오면
            diceNum[num1 + num2 - 2] = diceNum[num1 + num2 - 2] +1;
        }
        for(int i=0; i < diceNum.length; i++){
            System.out.println(i + 1 + "번 눈의 출현확률 : " +
                    String.format("%.6f",(double)diceNum[i]/COUNT));
        }
    }
}
