package interfaceQuiz;

public class Circle extends Figure{
    private int radius;
    private String name = "원";
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public void setWidth(int width) {}

    @Override
    public void setHeight(int height) {}

    @Override
    public String getName() {
        return this.name;
    }
}
