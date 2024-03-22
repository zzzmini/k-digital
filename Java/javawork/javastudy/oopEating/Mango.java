package oopEating;

public class Mango extends Fruit{
    private String name = "망고";
    private String taste = "달콤한 맛";
    public void eat(){
        System.out.println(taste + " " + name);
    }
    public void wow(){
        System.out.println("아이셔! 망고");
    }
}
