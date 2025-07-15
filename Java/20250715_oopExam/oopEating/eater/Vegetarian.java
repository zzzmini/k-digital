package oopEating.eater;

import oopEating.fruit.Fruit;

public class Vegetarian {
    private Fruit fruit;

    public Vegetarian(Fruit fruit) {
        this.fruit = fruit;
    }

    public void vegetableEat() {
        System.out.println(getName() + "가 " + fruit.eat()+ "를 먹어요");
    }

    public String getName() {
        return "채식주의자";
    }
}
