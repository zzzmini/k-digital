package oopCh07.animal;

import oopCh07.WildAnimal;

public class Tiger extends WildAnimal {

    @Override
    public void attack() {
        System.out.println("이빨로 공격");
    }
}
