package oopEating;

import oopEating.fruit.Apple;
import oopEating.fruit.Fruit;
import oopEating.fruit.Mango;
import oopEating.meat.Beaf;
import oopEating.meat.Chicken;
import oopEating.meat.Pork;

public class OOPEatingMain {
	public static void main(String[] args) {
		Fruit apple = new Apple();
		Fruit mango = new Mango();
		Vegetarian woman1 = new Vegetarian();
		woman1.vegetableEat(mango);
		
		MeatEater man1 = new MeatEater(new Beaf());
		man1.meatEat();
		
		System.out.println("=================");
		Eater eater = new Eater();
		eater.whatEat(apple);
		eater.whatEat(new Chicken());
	}
}









