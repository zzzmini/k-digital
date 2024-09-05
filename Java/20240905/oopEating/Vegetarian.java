package oopEating;

import oopEating.fruit.Fruit;

public class Vegetarian {
	private String name = "채식주의자";
	Fruit fruit;
	
	public void vegetableEat(Fruit fruit) {
		this.fruit = fruit;
		System.out.println(name + "가 " + this.fruit.eat());
	}
}
