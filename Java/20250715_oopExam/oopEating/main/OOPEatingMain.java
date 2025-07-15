package oopEating.main;

import oopEating.eater.MeatEater;
import oopEating.eater.Vegetarian;
import oopEating.fruit.Apple;
import oopEating.fruit.Fruit;
import oopEating.fruit.Mango;
import oopEating.fruit.Orange;
import oopEating.meat.Pork;

public class OOPEatingMain {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Vegetarian vegetarian = new Vegetarian(apple);
        vegetarian.vegetableEat();

        Vegetarian v2 = new Vegetarian(new Mango());
        v2.vegetableEat();

        MeatEater m1 = new MeatEater(new Pork());
        m1.meatEat();

        // 오버로딩 테스트
        System.out.println("================");
        Eater eater = new Eater();
        eater.whatEat(new Orange());
        eater.whatEat(new Pork());
    }
}
