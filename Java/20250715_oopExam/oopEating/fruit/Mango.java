package oopEating.fruit;

public class Mango implements Fruit {
    @Override
    public String getName() {
        return "망고";
    }

    @Override
    public String getTaste() {
        return "달콤한 맛";
    }

    @Override
    public String eat() {
        return getTaste() + " " + getName();
    }
}
