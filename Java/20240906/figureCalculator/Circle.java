package figureCalculator;

public class Circle extends Figure{
	private String name = "원";
	private int radius;
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setWidth(int width) {
	}

	@Override
	public void setHeight(int height) {
	}

	@Override
	public double area() {
		return Math.PI * (radius*radius);
	}
}
