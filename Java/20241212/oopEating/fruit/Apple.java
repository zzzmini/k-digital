package oopEating.fruit;

public class Apple implements Fruit{
    private String name = "사과";
    private String taste = "신맛";

    @Override
    public String eat() {
        return taste + "의 " + name + "을 먹어요";
    }
}
