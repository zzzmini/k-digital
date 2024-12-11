package oopCh06;

public class Ch06Main {
    public static void movePrint(Tiger tiger) {
        System.out.println(tiger.move());
    }
    public static void movePrint(LionImpl lion) {
        System.out.println(lion.move());
    }

    public static void move(AnimalInterface animal) {
        System.out.println(animal.move());
    }

    public static void main(String[] args) {
        AnimalInterface tiger = new Tiger();
        System.out.println("나는 " + tiger.getName());
        tiger.speak();
        if (tiger.육식인가()) {
            System.out.println("육식동물");
        } else {
            System.out.println("초식동물");
        }

        // 움직임 출력
        move(tiger);
//        movePrint(tiger);

        AnimalInterface lion = new LionImpl();
        System.out.println("나는 " + lion.getName());
        lion.speak();
        move(lion);
//        movePrint(lion);
    }
}
