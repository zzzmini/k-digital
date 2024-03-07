package myCarTest;

public class MyCar {
    public static void main(String[] args) {
        Car car = new Car();
        Car blueSonata = new Car();
        car.color = "빨강색";
        System.out.println("내 차의 색상은 : " + car.color);
        car.speedUp(10);
        car.stop();
        car.stop();

        System.out.println("-----------------");
        blueSonata.color = "파란색";
        blueSonata.speedUp(100);
    }
}
