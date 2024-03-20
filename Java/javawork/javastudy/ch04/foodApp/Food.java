package ch04.foodApp;

public class Food {
    private String name;
    private int price;

    public void myPrint(){
        System.out.println(this.name + " 가격은 " + this.price + "원 입니다.");
    }

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
