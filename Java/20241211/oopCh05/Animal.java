package oopCh05;

// new 가 안되는 아이
public abstract class Animal {
    abstract void speak();  // 자식들이 의무적으로 구현해야 하는 메서드

    public void defence() {
        System.out.println("모든 공격을 차단함");
    }
}
