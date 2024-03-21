package oopEating;

public class Apple extends Fruit{
    private String name = "사과";
    private String taste = "신맛";
    public void eat(){
        System.out.println(taste + " " + name);
    }
}
