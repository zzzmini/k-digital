package interfaceQuiz;

public class Rectangle extends Figure{
    private String name = "사각형";
    private int width;
    private int height;
    public Rectangle(int height, int width){
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return height * width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
