package oopEating.fruit;

public class Orange implements Fruit {
    private String name = "오렌지";
    private String taste = "시큼한 맛";

    @Override
    public String eat() {
        return taste + "의 " + name + "을 먹어요";
    }
}
