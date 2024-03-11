package ch06;

public class ArrayTest {
    public static void main(String[] args) {
// 문제1. 1부터 100까지 숫자 중에서 짝수만 더해서 출력
        int sum = 0;
        for(int i=1; i<=100; i++){
            if((i % 2) == 0){
                sum = sum + i;
            }
        }
        System.out.println(sum);
        sum = 0;
        for(int i=0; i<=100; i=i+2){
            sum = sum +i;
        }
        System.out.println(sum);
    }
}
