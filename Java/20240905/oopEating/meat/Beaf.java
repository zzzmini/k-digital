package oopEating.meat;

public class Beaf extends Meat{
	private String name = "소고기";
	private String brand = "한우";
	public String eat() {
		return brand + " " + name + "을 먹어요";
	}
}
