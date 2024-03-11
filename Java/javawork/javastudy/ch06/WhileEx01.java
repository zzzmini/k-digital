package ch06;

public class WhileEx01 {
    public static void main(String[] args) {
        boolean n = true;
        while (n){
            System.out.println("지금은 True입니다.");
            n = false;
        }

        do {
            System.out.println("지금은 True입니다.");
            if(n == true) break;
        } while (n = true);
    }
}
