package oopCh07.animal;

import oopCh07.WildAnimal;

public class Rhino extends WildAnimal {
    @Override
    public void attack() {
        System.out.println("뿔로 공격");
    }
}
