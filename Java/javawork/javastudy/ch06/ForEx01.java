package ch06;

public class ForEx01 {
    public static void main(String[] args) {
        // 9단 출력

        for(int i=2; i<=9; i++){
            System.out.println("======  " + i + "단 =====");
            for(int j=1; j<=9; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }
}
