package ch04.myCarOOP;

public class Car {
    private String brand;
    private String carName;
    private String color;

    public String getBrand(){
        return this.brand;
    }
    public String getCarName(){
        return this.carName;
    }


    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    private int nowSpeed = 0;

    public int getNowSpeed() {
        return nowSpeed;
    }

    public Car(String brand, String carName){
        this.brand = brand;
        this.carName = carName;
    }

    void speedUp(int speed){
        this.nowSpeed = this.nowSpeed + speed;
        if(this.nowSpeed >= 100){
            System.out.println("과속입니다.");
            currentSpeed();
        }else{
            currentSpeed();
        }
    }
    void stop(){
        this.nowSpeed = this.nowSpeed - 10;
        if(this.nowSpeed <= 0){
            System.out.println("멈췄습니다.");
            this.nowSpeed = 0;
            currentSpeed();
        }else{
            currentSpeed();
        }
    }
    void currentSpeed(){
        System.out.println("현재 속도는 " +
                this.nowSpeed + "km 입니다.");
    }
}
