package oopEating.fruit;

public class Apple extends Fruit{
	private String name = "사과";
	private String taste = "신맛";
	public String eat() {
		return taste + "의 " + name + "을 먹어요";
	}
}
