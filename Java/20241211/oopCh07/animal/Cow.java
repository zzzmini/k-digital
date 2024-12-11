package oopCh07.animal;

import oopCh07.MildAnimal;

public class Cow extends MildAnimal {
    @Override
    public void 채집() {
        System.out.println("풀 먹어요");
    }

    @Override
    public void hide() {
        System.out.println("외양간에 숨어요");
    }
}
