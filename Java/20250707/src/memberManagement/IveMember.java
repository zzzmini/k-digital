package memberManagement;

import java.util.Scanner;

public class IveMember {
    static String[] name = new String[6];
    static int[] age = new int[6];
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        // 데이터 초기화 하는 애 호출
        dataInit();
        // 멤버를 출력하는 함수 호출
        showMember();

        // 메뉴를 보여주는 함수
        showMenu();
    }

    private static void showMenu() {

        while (true) {
            System.out.println("1. 멤버보기 2. 멤버추가 3. 이름수정 4. 나이수정 0. 종료");
            int choice = sc.nextInt();
            switch (choice) {
                case 0 :
                    System.out.println("종료할거야");
                    return;
                case  1:
                    System.out.println("멤버보기");
                    showMember();
                    break;
                case 2:
                    System.out.println("추가");
                    // 추가할 자리 있는지 확인
                    int flag = 0;
                    for (int i = 0; i < name.length; i++) {
                        if (name[i] == null) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {
                        insertMember();
                    } else {
                        System.out.println("자리 없음.");
                    }
                    break;

                case 3:
                    System.out.println("이름수정");
                    updateName();
                    break;
                case 4:
                    System.out.println("나이수정");
                    updateAge();
                    break;
                default:
            }
        }
    }

    private static void insertMember() {
        System.out.println("새로운 멤버를 추가하는 화면입니다.");
        System.out.println("추가할 멤버의 이름을 입력하세요");
        String newName = sc.next();
        System.out.println(newName + "의 나이는 어떻게 되나요?");
        int newAge = sc.nextInt();

        // 빈 자리를 찾아서 추가
        for (int i = 0; i < name.length; i++) {
            if (name[i] == null) {
                name[i] = newName;
                age[i] = newAge;
                break;
            }
        }
        showMember();
    }

    private static void updateAge() {
        showMember();
        System.out.println("멤버나이를 수정하는 화면입니다.");
        System.out.println("수정할 멤버 번호를 입력하세요");
        int choice = sc.nextInt();
        System.out.println("수정할 나이를 입력하세요");
        int change = sc.nextInt();

        // 변경하기
        age[choice] = change;
        showMember();
    }

    private static void updateName() {
        showMember();
        System.out.println("멤버이름을 수정하는 화면입니다.");
        System.out.println("수정할 멤버 번호를 입력하세요");
        int choice = sc.nextInt();
        System.out.println("변경할 이름을 입력하세요");
        String change = sc.next();

        // 변경하기
        name[choice] = change;
        showMember();
    }

    private static void showMember() {
        // 멤버보여주기
        for (int i=0; i < name.length; i++) {
            // null이 아닐 때만 찍음
            if (name[i] != null) {
                String memberInfo = i + " / " + name[i] + " / " + age[i];
                System.out.println(memberInfo);
            }
        }
    }

    static void dataInit() {
        // 데이터 초기화
        name[0] = "안유진";
        name[1] = "장원영";
        age[0] = 21;
        age[1] = 20;
    }
}



