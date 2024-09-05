package oopEating.fruit;

public class Mango extends Fruit{
	private String name = "망고";
	private String taste = "달콤한 맛";
	public String eat() {
		return taste + "의 " + name + "을 먹어요";
	}
}
