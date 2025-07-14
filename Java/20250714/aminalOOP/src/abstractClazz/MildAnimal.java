package abstractClazz;

import myInterface.MoveAble;

public abstract class MildAnimal implements MoveAble {
    public abstract void collect();

    @Override
    public void left() {
        System.out.println("왼쪽으로 이동");
    }

    @Override
    public void right() {
        System.out.println("오른쪽으로 이동");
    }
}
