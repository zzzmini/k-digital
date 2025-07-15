package oopEating.main;

import oopEating.eater.MeatEater;
import oopEating.eater.Vegetarian;
import oopEating.fruit.Fruit;
import oopEating.meat.Meat;

public class Eater {
    // 과일 또는 육류를 선택해서 받아서
    // 실행하는 Overloading 구현
    public void whatEat(Fruit fruit) {
        Vegetarian v = new Vegetarian(fruit);
        v.vegetableEat();
    }

    public void whatEat(Meat meat) {
        MeatEater m = new MeatEater(meat);
        m.meatEat();
    }
}
