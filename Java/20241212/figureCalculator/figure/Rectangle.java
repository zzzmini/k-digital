package figureCalculator.figure;

import figureCalculator.Figure;

public class Rectangle extends Figure {
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
    public void setWidth(int witdh) {
        this.width = witdh;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

}
