package view;

import service.AdminService;

import java.util.Scanner;

public class AdminView {
    // AdminService 사용하기
    private AdminService adminService = new AdminService();

    private Scanner sc = new Scanner(System.in);
    public void adminScreen() {
        // 비밀번호 확인
        while (true) {
            System.out.println("관리자 화면");
            System.out.println("1. 메뉴 가격 수정하기  2. 메뉴 추가하기  3. 정산하기  4. 돌아가기");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // 메뉴 가격만 수정
                    adminService.menuUpdate();
                    break;
                case 2:
                    // 새로운 메뉴 추가(단, 총 5개까지만...현재 3개 있음)
                    adminService.menuInsert();
                    break;
                case 3:
                    // 제품별 총 판매액 출력
                    adminService.adminResult();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘 못 입력 했어요");
            }
        }
    }
}
