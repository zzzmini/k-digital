package figureCalculator;

public class Triangle extends Figure{
	private String name = "삼각형";
	private int width;
	private int height;
	
	@Override
	public String getName() {
		return this.name;
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
	public double area() {
		return (width * height)/2;
	}
}
