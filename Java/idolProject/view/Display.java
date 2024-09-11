package idol_project.view;

import java.util.Scanner;

import idol_project.IdolMain;
import idol_project.service.IdolService;
import idol_project.vo.Idol;

public class Display {
	public Scanner sc = new Scanner(System.in);
	// 서비스 클래스 인스턴스 생성하기
	public IdolService idolService = new IdolService();

	public void menu() {
		// 사용자 선택 및 입력화면 보이기
		String name = "";
		int age = 0;

		while (true) {
			System.out.println("1. 입력 2. 수정 3. 삭제  4. 종료");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("입력 선택");
				System.out.println("이름입력");
				name = sc.next();

				System.out.println("나이입력");
				age = sc.nextInt();
				Idol newIdol = new Idol(name, age);
				// 저장하기
				idolService.insert(IdolMain.key, newIdol);
				IdolMain.key++;
				// 맵 저장소 출력하기
				idolService.selectAll();

				break;
			case 2:
				System.out.println("수정 선택");
				System.out.println("수정 할 Key 입력 : ");
				int updateKey = sc.nextInt();
				// 키 존재 유무 확인
				if (idolService.keyExist(updateKey) == true) {
					// 수정처리
					System.out.println("이름입력");
					name = sc.next();

					System.out.println("나이입력");
					age = sc.nextInt();
					Idol updateIdol = new Idol(name, age);
					idolService.update(updateKey, updateIdol);
					idolService.selectAll();
				} else {
					// 오류 표시 리턴
					System.out.println("키가 존재하지 않습니다.");
					return;
				}

				break;
			case 3:
				System.out.println("삭제 선택");
				System.out.println("삭제 할 Key 입력 : ");
				int deleteKey = sc.nextInt();
				// 키 존재 유무 확인
				if (idolService.keyExist(deleteKey) == true) {
					// 삭제처리
					idolService.delete(deleteKey);
					idolService.selectAll();
				} else {
					// 오류 표시 리턴
					System.out.println("키가 존재하지 않습니다.");
					return;
				}
				
				break;
			case 4:
				System.out.println("종료 선택");
				return;
			default:
				System.out.println("다시 입력");
				break;
			}
		}
	}
}
