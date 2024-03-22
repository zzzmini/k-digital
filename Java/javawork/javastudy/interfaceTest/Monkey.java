package interfaceTest;

public class Monkey extends MildAnimalImpl{
    @Override
    public void gathering() {
        System.out.println("바나나 채집");
    }

    @Override
    public String hide() {
        return "나무위로 숨기";
    }
}
