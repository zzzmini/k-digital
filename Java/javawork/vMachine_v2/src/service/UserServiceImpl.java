package service;

import myInterface.UserInterface;

public class UserServiceImpl implements UserInterface {
    @Override
    public void insertCoin() {
        System.out.println("사용자 메뉴 - 동전투입");
    }

    @Override
    public void returnCoin() {
        System.out.println("사용자 메뉴 - 잔돈반환");
    }

    @Override
    public void choiceMenu() {
        System.out.println("사용자 메뉴 - 메뉴선택");
    }
}
