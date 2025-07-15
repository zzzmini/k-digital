package oopEating.fruit;

public class Apple implements Fruit{
    @Override
    public String getName() {
        return "사과";
    }

    @Override
    public String getTaste() {
        return "신맛";
    }

    @Override
    public String eat() {
        return getTaste() + " " + getName();
    }
}
