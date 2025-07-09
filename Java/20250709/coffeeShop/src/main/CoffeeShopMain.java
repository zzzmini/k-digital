package main;

import vo.Coffee;

public class CoffeeShopMain {
    public static void main(String[] args) {
        // 아이스 커피 생성하기
        Coffee iceCoffee = new Coffee();
        iceCoffee.setName("아이스커피");
        iceCoffee.setPrice(2000);
        // 출력
        System.out.println(iceCoffee.getName());
        System.out.println(iceCoffee.toString());

        // 메가리 만들기
        Coffee megari = new Coffee();
        megari.setName("메가리");
        megari.setPrice(3000);
        // 메가리커피 가격 출력
        int megariPrice = megari.getPrice();
        System.out.println(megariPrice);
        // 메가리 인스턴스 내용을 출력
        System.out.println(megari);

        // 카페라떼 생성
        Coffee cafeLatte = new Coffee("카페라떼", 3800);
        System.out.println(cafeLatte.toString());

        // Coffee 타입의 배열을 3개 선언
        int[] value = new int[3];
        Coffee[] coffees = new Coffee[3];
        coffees[0] = iceCoffee;
        coffees[1] = megari;
        coffees[2] = cafeLatte;
        // 메가리 커피 가격
        System.out.println(coffees[1].getPrice());
        coffees[1].setName("메가리커피");
        System.out.println(coffees[1].toString());
        System.out.println("===================");
        // for ~ loop 로 출력하기
        for (int i = 0; i < coffees.length; i++) {
            System.out.println(coffees[i].toString());
        }
        System.out.println("===================");
        // 다른 형식의 for
        int[] a = {1, 2, 3};
        for (int x : a) {
            System.out.println(x);
        }
        // coffees 안에 내용을 출력
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
