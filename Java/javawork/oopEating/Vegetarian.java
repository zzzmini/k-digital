package oopEating;

public class Vegetarian {
    private Fruit fruit;
    private String name = "채식주의자";
    public void vegetableEat(Fruit fruit){
        this.fruit = fruit;
        System.out.print(this.name + "가 ");
        fruit.eat();
    }
}
