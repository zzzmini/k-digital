package figure;

public class Triangle extends Figure{
    private int width;
    private int height;

    @Override
    public double area() {
        return (double) (width * height) / 2;
    }

    @Override
    public String getName() {
        return "삼각형";
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
