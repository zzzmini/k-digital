package quiz_01;

import java.util.Scanner;

public class Q_11_switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("성적입력");
        int score = sc.nextInt();

        int bound = score / 10;

        String grade = "";
        switch (bound) {
            case 10:
                grade = "A";
                break;
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            default:
                grade = "F";
                break;
        }
        System.out.println(grade);
    }
}
