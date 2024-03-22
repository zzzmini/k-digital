package interfaceTest;

import ch00.Man;

public class Hyena extends WildAnimalImpl{
    @Override
    public void attack() {
        System.out.println("이빨로 공격");
    }
}
