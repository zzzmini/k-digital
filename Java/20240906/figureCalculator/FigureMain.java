package figureCalculator;

public class FigureMain {
	public static void calArea(Figure figure) {
		System.out.println(figure.getName() + "의 넓이는 " + figure.area());
	}

	public static void main(String[] args) {
		Figure triangle = new Triangle();
		triangle.setHeight(10);
		triangle.setWidth(5);

		Figure rectangle = new Rectangle();
		rectangle.setWidth(10);
		rectangle.setHeight(5);

		Circle circle = new Circle();
		circle.setRadius(5);

		calArea(triangle);
		calArea(rectangle);
		calArea(circle);
	}
}
