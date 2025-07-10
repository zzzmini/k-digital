package arrayListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DogMain {
    public static List<Dog> dogList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DogService dogService = new DogService();

        while (true) {
            System.out.println("0.출력 1.신규 2.수정 3.삭제 4.종료");
            int num = sc.nextInt();
            switch (num) {
                case 0:
                    dogService.printDog();
                    break;
                case 1:
                    dogService.addDog();
                    break;
                case 2:
                    dogService.updateDog();
                    break;
                case 3:
                    dogService.deleteDog();
                    break;
                case 4:
                    return;
            }
        }
    }
}
