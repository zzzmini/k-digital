package telBookApp;

import java.sql.Connection;
import java.util.Scanner;

import telBookApp.db.DBConn;
import telBookApp.view.DisplayMenu;

public class TelBookMain {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		DisplayMenu menu = new DisplayMenu();
		int num;
		while (true) {
			System.out.println("1. 입력 2. 수정 3. 삭제 4. 전체출력 5. 검색 6. 종료");
			num = sc.nextInt();
			switch (num) {
			case 1:
				menu.menuInput();
				break;
			case 2:
				menu.menuUpdate();
				break;
			case 3:
				menu.menuDelete();
				break;
			case 4:
				menu.menuShowAll();
				break;
			case 5:
				menu.menuSearch();
				break;
			case 6:
				return;
			default:
				System.out.println("잘못 입력했습니댜.");
				break;
			}
		}
	}
}
