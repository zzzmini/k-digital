package oopCh07;

import oopCh07.animal.Monkey;
import oopCh07.animal.Tiger;

public class Ch07Main {
    public static void moveWildAnimal(WildMoveInterface wild) {
        wild.up();
        wild.left();
    }

    public static void moveMildAnimal(MildMoveInterface mild) {
        mild.hide();
        mild.right();
    }

    public static void main(String[] args) {
        MildAnimal monkey = new Monkey();
        monkey.채집();
        moveMildAnimal(monkey);
        System.out.println("============");
        WildAnimal tiger = new Tiger();
        tiger.attack();
        moveWildAnimal(tiger);
    }
}
