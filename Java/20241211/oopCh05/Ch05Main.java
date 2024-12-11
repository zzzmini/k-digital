package oopCh05;

public class Ch05Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal dog2 = new Dog();
        Cat cat = new Cat();

        cat.speak();
        cat.그루밍();
        cat.defence();

        dog.speak();
        dog.defence();

        dog2.speak();
        dog2.defence();
    }
}
