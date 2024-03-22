package interfaceQuiz;

public class Triangle extends Figure{
    private String name = "삼각형";
    private int width;
    private int height;
    public Triangle(int height, int width){
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return height * width * 0.5;
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
