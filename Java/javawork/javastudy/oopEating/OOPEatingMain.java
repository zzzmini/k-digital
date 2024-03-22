package oopEating;

import ch04.starcraft.ProtosUnit;

import java.util.Scanner;

public class OOPEatingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Vegetarian w1 = new Vegetarian();
        Fruit apple = new Apple();
        ((Apple)apple).wow();

        w1.vegetableEat(new Mango());
        Meat pork = new Pork();
        MeatEater man1 = new MeatEater(new Pork());
        man1.meatEat();
        System.out.println("========================");
        Eater eater = new Eater();
        eater.whatEat(new Chicken());
        eater.whatEat(new Mango());
    }
}
