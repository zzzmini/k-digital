package oopEating;

import java.util.Scanner;

public class Vegetarian {
    Fruit fruit;
    Scanner sc;
    private String name = "채식주의자";
    public void vegetableEat(Fruit fruit){
        this.fruit = fruit;
        System.out.print(this.name + "가 ");
        fruit.eat();
    }
}
