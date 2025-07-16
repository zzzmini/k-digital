package view;

import java.util.Scanner;

public class UserView {
    private Scanner sc = new Scanner(System.in);

    public void insertView() {
        System.out.println("=== 전화번호 등록 ===");
    }

    public void updateView() {
        System.out.println("=== 전화번호 수정 ===");
    }

    public void deleteView() {
        System.out.println("=== 전화번호 삭제 ===");
    }

    public void findAllView() {
        System.out.println("=== 전화번호 목록 ===");
    }

    public void searchView() {
        System.out.println("=== 전화번호 검색 ===");
    }
}
