package oopEating.meat;

public class Chicken implements Meat{
    @Override
    public String getName() {
        return "닭고기";
    }

    @Override
    public String getBrand() {
        return "하림";
    }

    @Override
    public String eat() {
        return getBrand() + " " + getName();
    }
}
