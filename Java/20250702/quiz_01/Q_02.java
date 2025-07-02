package quiz_01;

public class Q_02 {
    public static void main(String[] args) {
        System.out.println("For");
        for (int i = 10; i >= 1; i--) {
            if (i == 3) continue;
            System.out.println(i);
        }
        System.out.println("While");
        int j = 11;
        while (j > 1) {
            j--;
            if (j == 3) continue;
            System.out.println(j);
        }
    }
}
