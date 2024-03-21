package oopEating;

public class Beaf extends Meat{
    private String name = "소고기";
    private String taste = "한우";

    public void eat() {
        System.out.println(taste + " " + name);
    }
}