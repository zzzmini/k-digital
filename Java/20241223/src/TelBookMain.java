import telBookView.TelBookView;

import java.util.Scanner;

public class TelBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TelBookView view = new TelBookView();

        int num = 0;
        while (true) {
            System.out.println("1.입력 2.수정 3.삭제 4.전체출력 5.이름검색 6.종료");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    view.inputView();
                    break;
                case 2:
                    view.updateView();
                    break;
                case 3:
                    view.deleteView();
                    break;
                case 4:
                    view.printAll();
                    break;
                case 5:
                    view.searchNameView();
                    break;
                case 6:
                    // 종료
                    return;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
