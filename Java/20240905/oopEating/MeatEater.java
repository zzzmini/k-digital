package oopEating;

import oopEating.fruit.Fruit;
import oopEating.meat.Meat;

public class MeatEater {
	private String name = "육식주의자";
	Meat meat;
	
	public MeatEater(Meat meat) {
		this.meat = meat;
	}
	
	public void meatEat() {
		System.out.println(name + "가 " + meat.eat());
	}
}
