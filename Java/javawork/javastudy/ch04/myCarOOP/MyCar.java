package ch04.myCarOOP;

public class MyCar {
    public static void main(String[] args) {
        Car sonata = new Car("현대", "소나타");
        Car k5 = new Car("기아", "K5");

//        sonata.color = "빨강색";
        System.out.println(sonata.getBrand() + " : " + sonata.getCarName());
        sonata.setColor("빨강색");
        System.out.println("내 차의 색상은 : " + sonata.getColor());
        sonata.speedUp(10);
        System.out.println("현재 스피드 : " + sonata.getNowSpeed());
        sonata.stop();
        sonata.stop();

        System.out.println("-----------------");
//        blueSonata.color = "파란색";
        k5.setColor("파랑");
        k5.speedUp(100);
    }
}
