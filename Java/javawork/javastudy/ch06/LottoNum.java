package ch06.quiz;

import java.util.Random;

public class LottoNum {
    public static void main(String[] args) {
        Random random = new Random();
        int lottoNum[] = new int[6];
        int currNum;
        int index = 0;
        boolean flag = false;
        do{
            currNum = random.nextInt(45)+1;
            for(int i=0; i<lottoNum.length; i++){
                if(currNum == lottoNum[i]){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                lottoNum[index] = currNum;
                index = index + 1;
            }
        } while (index <= 5);
        for(int result : lottoNum){
            System.out.print(result + " ");
        }
    }
}
