package oopEating;

public class Orange extends Fruit{
    private String name = "오렌지";
    private String taste = "시큼한 맛";
    public void eat(){
        System.out.println(taste + " " + name);
    }
}
