package ch04.oopTest;

public class Cat {
    String name;
    String color;
    // 기본생성자(Default constructor)
    public Cat(){}
    public Cat(String cName, String cColor){
        System.out.println("고양이가 탄생했습니다.");
        name = cName;
        color = cColor;
    }
}
