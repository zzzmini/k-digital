package wildAnimal;

import abstractClazz.WildAnimal;

public class Lion extends WildAnimal {
    @Override
    public void attack() {
        System.out.println("사자는 이빨로 공격");
    }

    @Override
    public void up() {
        System.out.println("사자 : 나무 위 기어오르기");
    }

    @Override
    public void down() {
        System.out.println("사자 : 살금살금 기어가기");
    }

    @Override
    public void left() {
        System.out.println("사자 : 왼쪽 이동");

    }

    @Override
    public void right() {
        System.out.println("사자 : 오른쪽 이동");
    }

    @Override
    public void hide() {

    }
}
