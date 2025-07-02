package quiz_01;

public class Q_01 {
    public static void main(String[] args) {
        System.out.println("for");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                continue;
            }
            System.out.println(i);
            // 코드 정리 단축키
            // ctrl + alt + L
        }
        System.out.println("while");
        int j = 0;
        while (j < 10) {
            j ++;
            if (j == 6) continue;
            System.out.println(j);
        }
    }
}
