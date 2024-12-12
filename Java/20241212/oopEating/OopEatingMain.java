package oopEating;

import oopEating.fruit.Apple;
import oopEating.fruit.Fruit;
import oopEating.fruit.Mango;
import oopEating.meat.Beaf;
import oopEating.meat.Chicken;
import oopEating.meat.Meat;

public class OopEatingMain {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit mango = new Mango();
        Vegetarian w1 = new Vegetarian(apple);
        Vegetarian w2 = new Vegetarian(mango);
        w1.vegetableEat();
        w2.vegetableEat();

        Meat chicken = new Chicken();
        Meat beaf = new Beaf();
        MeatEater m1 = new MeatEater();

        m1.meatEat(chicken);
        m1.meatEat(beaf);
    }
}
