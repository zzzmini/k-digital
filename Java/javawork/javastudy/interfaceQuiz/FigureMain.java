package interfaceQuiz;

public class FigureMain {
    public static void main(String[] args) {
        Figure triangle = new Triangle(10, 5);
        System.out.println(triangle.getName() + "의 너비는 : " + triangle.area());

        Figure rectangle = new Rectangle(10 , 5);
        System.out.println(rectangle.getName() + "의 너비는 : " + rectangle.area());

        Figure circle = new Circle(5);
        System.out.println(circle.getName() + "의 너비는 : " + circle.area());
    }
}
