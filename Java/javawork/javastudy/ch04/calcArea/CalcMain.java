package ch04.calcArea;

public class CalcMain {
    public static void main(String[] args) {
        Figure figure = new Figure(3, 4);
        Rectangle rectangle = new Rectangle(figure);
        rectangle.printResult();

        Triangle triangle = new Triangle(3,2);
        triangle.printResult();
    }
}
