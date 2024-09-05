package oopEating.meat;

public class Pork extends Meat{
	private String name = "돼지고기";
	private String brand = "한돈";
	public String eat() {
		return brand + " " + name + "을 먹어요";
	}
}
