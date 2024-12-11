package oopCh06;

public class LionImpl implements AnimalInterface{
    @Override
    public String getName() {
        return "사자";
    }

    @Override
    public void speak() {
        System.out.println("사자양");
    }

    @Override
    public boolean 육식인가() {
        return true;
    }

    @Override
    public String move() {
        return "잘 걸어다님";
    }
}
