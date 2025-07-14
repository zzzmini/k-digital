package main;

import abstractClazz.MildAnimal;
import abstractClazz.WildAnimal;
import mildAnimal.Monkey;
import wildAnimal.Lion;

public class AnimalMain {
    public static void move(WildAnimal wildAnimal) {
        wildAnimal.up();
        wildAnimal.down();
    }

    public static void move(MildAnimal mildAnimal) {
        mildAnimal.left();
        mildAnimal.right();
    }

    public static void main(String[] args) {
        MildAnimal monkey = new Monkey();
        WildAnimal lion = new Lion();
        lion.attack();

        monkey.collect();
        monkey.hide();

        move(monkey);
        move(lion);

    }
}
