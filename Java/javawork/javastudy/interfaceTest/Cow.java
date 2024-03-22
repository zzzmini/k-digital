package interfaceTest;

public class Cow extends MildAnimalImpl{
    @Override
    public void gathering() {
        System.out.println("풀을 채집");
    }

    @Override
    public String hide() {
        return "외양간에 숨기";
    }
}
