package myCarTest;

public class Car {
    final String brand = "현대";
    final String carName = "소나타";
    String color;
    int nowSpeed = 0;
    void speedUp(int speed){
        nowSpeed = nowSpeed + speed;
        if(nowSpeed >= 100){
            System.out.println("과속입니다.");
            currentSpeed();
        }else{
            currentSpeed();
        }
    }
    void stop(){
        nowSpeed = nowSpeed - 10;
        if(nowSpeed <= 0){
            System.out.println("멈췄습니다.");
            nowSpeed = 0;
            currentSpeed();
        }else{
            currentSpeed();
        }
    }
    void currentSpeed(){
        System.out.println("현재 속도는 " +
                nowSpeed + "km 입니다.");
    }
}
