package figureCalculator;

import figureCalculator.figure.Circle;
import figureCalculator.figure.Rectangle;
import figureCalculator.figure.Triangle;

public class FigureMain {
    public static void calArea(Figure figure) {
        System.out.println(figure.getName() + "의 너비는 " + figure.area());
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        calArea(circle);

        // 사각형
        Figure rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(5);
        calArea(rectangle);
        // 삼각형
        Figure triangle = new Triangle();
        triangle.setHeight(5);
        triangle.setWidth(10);
        calArea(triangle);
    }
}
