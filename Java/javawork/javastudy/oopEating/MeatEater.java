package oopEating;

public class MeatEater {
    private String name = "육식주의자";
    private Meat meat ;
    public MeatEater(Meat meat){
        this.meat = meat;
    }
    public void meatEat(){
        System.out.print(this.name + "가 ");
        meat.eat();
    }
}
