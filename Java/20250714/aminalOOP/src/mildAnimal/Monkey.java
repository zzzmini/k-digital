package mildAnimal;

import abstractClazz.MildAnimal;

public class Monkey extends MildAnimal {
    @Override
    public void collect() {
        System.out.println("원숭이는 바나나를 모아요");
    }

    @Override
    public void up() {
        System.out.println("원숭이는 나무사이로 올라요");
    }

    @Override
    public void down() {
        System.out.println("원숭이는 가끔 떨어져요");
    }

    @Override
    public void hide() {
        System.out.println("나무위로 숨어요");
    }
}
