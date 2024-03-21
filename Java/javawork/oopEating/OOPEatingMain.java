package oopEating;

public class OOPEatingMain {
    public static void main(String[] args) {
        Vegetarian w1 = new Vegetarian();
        Fruit apple = new Apple();
        w1.vegetableEat(new Mango());

        MeatEater man1 = new MeatEater(new Pork());
        man1.meatEat();
        System.out.println("========================");
        Eater eater = new Eater();
        eater.whatEat(new Chicken());
        eater.whatEat(new Mango());
    }
}
