package oopEating;

import ch00.Man;

public class Chicken extends Meat{
    private String name = "닭고기";
    private String taste = "하림";

    public void eat() {
        System.out.println(taste + " " + name);
    }
}
