package figure;

public class Rectangle extends Figure{
    private int width;
    private int height;

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String getName() {
        return "사각형";
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
