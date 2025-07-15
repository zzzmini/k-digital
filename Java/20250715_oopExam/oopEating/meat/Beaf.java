package oopEating.meat;

public class Beaf implements Meat {
    @Override
    public String getName() {
        return "소고기";
    }

    @Override
    public String getBrand() {
        return "한우";
    }

    @Override
    public String eat() {
        return getBrand() + " " + getName();
    }
}
