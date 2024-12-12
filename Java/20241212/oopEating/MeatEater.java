package oopEating;

import oopEating.meat.Meat;

public class MeatEater {
    private String name = "육식주의자";
    public void meatEat(Meat meat) {
        System.out.println(name + "가 " + meat.eat());
    }
}
