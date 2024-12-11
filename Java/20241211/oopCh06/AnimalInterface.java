package oopCh06;

public interface AnimalInterface {
    String getName();
    void speak(); // 동물의 울음소리 출력 기능

    boolean 육식인가(); // 육식인지 초식인지 확인 : 육식 - true, 초식 - false

    String move();

}
