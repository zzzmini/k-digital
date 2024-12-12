package figureCalculator.figure;

import figureCalculator.Figure;

public class Circle extends Figure {
    private int radius;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "원";
    }

    @Override
    public void setWidth(int witdh) {

    }

    @Override
    public void setHeight(int height) {

    }
}
