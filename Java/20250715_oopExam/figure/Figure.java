package figure;

public abstract class Figure implements FigureInterface {
    // abstract 클래스가 인테페이스를 구현할 때
    // 인터페이스의 모든 메서드를 구현할 의무는 없다.
    // 만약, abstract class 에서 구현하지 않은 메서드는
    // abstract 클래스를 상속받는 자식이 구현해야 한다.
    public abstract double area();

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }
}
