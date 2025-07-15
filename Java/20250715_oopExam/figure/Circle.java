package figure;

public class Circle extends Figure{
    private int radius;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String getName() {
        return "원";
    }
}
