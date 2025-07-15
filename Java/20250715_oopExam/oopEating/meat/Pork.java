package oopEating.meat;

public class Pork implements Meat {
    @Override
    public String getName() {
        return "돼지고기";
    }

    @Override
    public String getBrand() {
        return "한돈";
    }

    @Override
    public String eat() {
        return getBrand() + " " + getName();
    }
}
