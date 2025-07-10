package arrayListTest;

import java.util.Scanner;

public class DogService {
    Scanner sc = new Scanner(System.in);
    // CRUD 기능
    // Create
    public void addDog() {
        Dog dog = new Dog();
        System.out.println("강아지의 이름은 : ");
        String name = sc.next();
        System.out.println("강아지의 나이는 : ");
        int age = sc.nextInt();
        dog.setName(name);
        dog.setAge(age);

        // List에 추가
        DogMain.dogList.add(dog);
    }

    // Read
    public void printDog() {
        for (int i = 0; i < DogMain.dogList.size(); i++) {
            System.out.printf("index : " + i + " : ");
            System.out.println(DogMain.dogList.get(i));
        }
    }
    // Update
    public void updateDog() {
        // 리스트 보여준다.
        printDog();
        // 수정할 강아지 이름을 입력받는다.
        System.out.println("수정할 강아지 이름 입력 : ");
        String name = sc.next();

        // 해당 강아지의 인덱스를 찾는다.
        int updateIndex = -1;
        for (int i = 0; i < DogMain.dogList.size(); i++) {
            if (DogMain.dogList.get(i).getName().equals(name)) {
                updateIndex = i;
                break;
            }
        }
        // 강아지가 존재하는지 확인
        if (updateIndex == -1) {
            System.out.println("찾는 강아지가 없습니다.");
            return;
        } else {
            // 나이와 이름을 입력받아서 수정한다.
            System.out.println("수정할 이름 : ");
            String newName = sc.next();
            System.out.println("수정할 나이 : ");
            int newAge = sc.nextInt();
            Dog updateDog = new Dog();
            updateDog.setName(newName);
            updateDog.setAge(newAge);
            DogMain.dogList.set(updateIndex, updateDog);
            printDog();
        }
    }


    // Delete
    public void deleteDog() {
        printDog();
        System.out.println("삭제할 강아지 이름을 입력하세요");
        String deleteName = sc.next();
        // 삭제할 이름의 강아지 인덱스를 찾아요
        int dogIndex = -1;
        for (int i = 0; i < DogMain.dogList.size(); i++) {
            if (DogMain.dogList.get(i).getName().equals(deleteName)) {
                dogIndex = i;
                break;
            }
        }
        if (dogIndex == -1) {
            System.out.println("삭제할 강아지가 없어요");
        } else {
            System.out.println("삭제되었습니다.");
            DogMain.dogList.remove(dogIndex);
            printDog();
        }
    }
}
