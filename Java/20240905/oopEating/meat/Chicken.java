package oopEating.meat;

public class Chicken extends Meat{
	private String name = "닭고기";
	private String brand = "하림";
	public String eat() {
		return brand + " " + name + "을 먹어요";
	}
}
