package oopEating;

import oopEating.fruit.Fruit;
import oopEating.meat.Meat;

public class Eater {
	public void whatEat(Fruit fruit) {
		Vegetarian vegetarian = new Vegetarian();
		vegetarian.vegetableEat(fruit);
	}
	public void whatEat(Meat meat) {
		MeatEater meatEater = new MeatEater(meat);
		meatEater.meatEat();
	}
}
