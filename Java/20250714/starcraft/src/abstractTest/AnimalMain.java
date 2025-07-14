package abstractTest;

public class AnimalMain {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.hello();
        dog.speak();

        cat.speak();

        Animal bird = new Bird();
        bird.speak();
    }
}
