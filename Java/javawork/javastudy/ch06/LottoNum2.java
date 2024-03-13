package ch06.quiz;

import java.util.Random;

public class LottoNum2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] lottoNum = new int[6];
        for(int i = 0; i < lottoNum.length; i++){
            lottoNum[i] = random.nextInt(45) + 1;
            for(int k = 0; k < i; k++){
                if(lottoNum[i] == lottoNum[k]){
                    i = i - 1;
                    break;
                }
            }
        }
        for(int result: lottoNum){
            System.out.print(result + " ");
        }
    }
}
