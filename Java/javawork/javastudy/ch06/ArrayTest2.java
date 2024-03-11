package ch06;

public class ArrayTest2 {
    public static void main(String[] args) {
        // 1부터 10사이의 값을 더합니다. 단, 5는 빼고 해 주세요.
        int sum = 0;
        for(int i=1; i<=10; i++){
            if(i == 5){
                // continue, break, return
                return;
            } else {
                System.out.println(i);
            }
        }
        System.out.println("메서드 종료");
    }
}
