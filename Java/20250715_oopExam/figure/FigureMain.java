package figure;

public class FigureMain {
    public static void calArea(Figure figure){
        System.out.println(figure.getName() + "의 넓이는 " + figure.area());
    }
    public static void main(String[] args) {
        // 사각형 너비 구하기
        Figure rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(5);
        calArea(rectangle);

        // 삼각형 너비 구하기
        Figure triangle = new Triangle();
        triangle.setWidth(10);
        triangle.setHeight(5);
        calArea(triangle);

        // 원의 너비 구하기
        Circle circle = new Circle();
        circle.setRadius(5);
        calArea(circle);
    }
}
