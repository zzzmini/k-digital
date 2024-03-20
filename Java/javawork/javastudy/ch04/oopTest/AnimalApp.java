package ch04.oopTest;

public class AnimalApp {
    public static void main(String[] args) {
        Cat whiteCat = new Cat();
        whiteCat.name = "야옹이";
        whiteCat.color = "흰색";
        System.out.println(whiteCat.name + " " + whiteCat.color);

        Cat blackCat = new Cat("네로", "검정");
        System.out.println(blackCat.name);
        System.out.println(blackCat.color);

        System.out.println("===========================");
        Dog.type = "마르티즈";
        Dog myDog = new Dog("순돌이", "흰색");
//        myDog.color = "검정";

        myDog.setColor("검정");
        System.out.println("강아지 이름 : " + myDog.getName());
        System.out.println("강아지 색상 : " + myDog.getColor());
    }
}
