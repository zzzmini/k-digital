package quiz_01;

import java.util.Scanner;

public class Q_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("성적입력");
        int score = sc.nextInt();
        String grade = "";
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println(grade);
    }
}
