package oopEating;

public class Pork extends Meat{
    private String name = "돼지고기";
    private String taste = "한돈";

    public void eat() {
        System.out.println(taste + " " + name);
    }
}
