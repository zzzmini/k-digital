package main;

import view.ViewImpl;
import view.ViewInterface;

import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {

        ViewInterface view = new ViewImpl();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.입력 2.수정 3.삭제 4.리스트 5.종료");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    view.addView();
                    break;
                case 2:
                    view.updateView();
                    break;
                case 3:
                    view.removeView();
                    break;
                case 4:
                    view.listView();
                    break;
                case 5:
                    return;
            }
        }
    }
}
