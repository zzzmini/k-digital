package oopCh05;

public class Cat extends Animal{
    @Override
    void speak() {
        System.out.println("야옹");
    }

    public void 그루밍() {
        System.out.println("고양이가 그루밍 함.");
    }
}
