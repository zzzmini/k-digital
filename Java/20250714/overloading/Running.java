package overloading;
// Overloading은 함수의 이름 하나에
// 전달되는 인자에 따라 실행함수가 달라지는 것.
public class Running {
    public void run() {
        System.out.println("기본 달리기");
    }

    public void run(int k) {
        System.out.println(k + "km 달리기");
    }

    public void run(double x) {
        System.out.println("나는 " + x + "입니다.");
    }

    public void run(int hour, int k) {
        System.out.println(hour + "시간동안 " + k  + "km 달리기");
    }
}
