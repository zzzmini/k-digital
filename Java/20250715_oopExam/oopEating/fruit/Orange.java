package oopEating.fruit;

public class Orange implements Fruit {
    @Override
    public String getName() {
        return "오렌지";
    }

    @Override
    public String getTaste() {
        return "시큼한 맛";
    }

    @Override
    public String eat() {
        return getTaste() + " " + getName();
    }
}
