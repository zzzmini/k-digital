package oopEating.eater;

import oopEating.meat.Meat;

public class MeatEater {
    private Meat meat;

    public MeatEater(Meat meat) {
        this.meat = meat;
    }

    public void meatEat() {
        System.out.println("육식주의자가 " + meat.eat()+ "를 먹어요");
    }
}
