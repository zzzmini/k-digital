package idol_project;

import java.util.HashMap;
import java.util.Map;

import idol_project.view.Display;
import idol_project.vo.Idol;

public class IdolMain {
	public static int key = 1;  // 맵에 사용할 id(primary key)
	// 저장소
	public static Map<Integer, Idol> strore = new HashMap<>();
	
	//Display 클래스 사용하기
	public static Display display = new Display();
	
	public static void main(String[] args) {
		// 초기 화면 불러오기
		display.menu();
	}
}
